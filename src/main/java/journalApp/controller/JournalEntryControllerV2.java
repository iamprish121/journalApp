//start-2
//package journalApp.controller;
//import journalApp.entity.JournalEntry;
//import journalApp.service.JournalEntryService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//import java.time.LocalDateTime;
//
//
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryControllerV2 {
//    @Autowired
//    private JournalEntryService journalEntryService;
//
//    @GetMapping
//     public List<JournalEntry> getAll(){
//        return journalEntryService.getAllEntries();
//    }
//
//    @PostMapping
//    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
//        myEntry.setDate(LocalDateTime.now());
//        journalEntryService.saveEntry(myEntry);
//        return myEntry;
//    }
//
//    @GetMapping("/id/{myId}")
//    public JournalEntry getById(@PathVariable ObjectId myId){
//        return journalEntryService.findById(myId).orElse(null);
//    }
//    @DeleteMapping("id/{myId}")
//    public boolean deleteById(@PathVariable ObjectId myId){
//        journalEntryService.deleteById(myId);
//        return true;
//    }
//    @PutMapping("/id/{myId}")
//    public JournalEntry updateById(@PathVariable ObjectId myId,@RequestBody JournalEntry newEntry) {
//        JournalEntry old = journalEntryService.findById(myId).orElse(null);
//        if(old != null){
//            old.setTitle(newEntry.getTitle() !=null  && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
//            old.setContent(newEntry.getContent()!= null && !newEntry.getContent().equals("")? newEntry.getContent() : old.getContent());
//        }
//        journalEntryService.saveEntry(old);
//        return old;
//    }
//}
