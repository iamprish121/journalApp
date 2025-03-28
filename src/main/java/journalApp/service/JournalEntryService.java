package journalApp.service;

import journalApp.entity.JournalEntry;
import journalApp.entity.User;
import journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    private static final Logger log = LoggerFactory.getLogger(JournalEntryService.class);
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    public List<JournalEntry> getAllEntries(){
        return journalEntryRepository.findAll();
    }
    @Transactional
    public void saveEntry(JournalEntry journalEntry , String userName){
        try {
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
//            user.setUserName(null);
            userService.saveEntry(user);
        }catch (Exception e){
            log.error("Exception",e);
            throw new RuntimeException("An error occurred while saving the entry.",e);
        }
    }
    public void saveEntry(JournalEntry journalEntry){
        try {
            journalEntryRepository.save(journalEntry);
        }catch (Exception e){
            log.error("Exception",e);
        }
    }
    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }
    public void deleteById(ObjectId id, String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }

}
