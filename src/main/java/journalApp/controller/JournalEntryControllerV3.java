//package journalApp.controller;
//
//import journalApp.entity.JournalEntry;
//import journalApp.service.JournalEntryService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryControllerV3 {
//    @Autowired
//    private JournalEntryService journalEntryService;
//
//
//    @GetMapping
//     public ResponseEntity<?> getAll(){
//        List<JournalEntry> all = journalEntryService.getAllEntries();
//        if(all != null && !all.isEmpty()){
//            return new ResponseEntity<>(all,HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//
//    @PostMapping
//    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
//       try {
//           journalEntryService.saveEntry(myEntry);
//           return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
//       }catch (Exception e){
//           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//       }
//    }
//
//
//    @GetMapping("/id/{myId}")
//    public ResponseEntity<JournalEntry> getById(@PathVariable ObjectId myId){
//        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
//        if(journalEntry.isPresent()){
//            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//
//    @DeleteMapping("id/{myId}")
//    public ResponseEntity<?> deleteById(@PathVariable ObjectId myId){
//        journalEntryService.deleteById(myId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//
//    @PutMapping("/id/{myId}")
//    public ResponseEntity<?> updateById(@PathVariable ObjectId myId,@RequestBody JournalEntry newEntry) {
//        JournalEntry old = journalEntryService.findById(myId).orElse(null);
//        if(old != null){
//            old.setTitle(newEntry.getTitle() !=null  && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
//            old.setContent(newEntry.getContent()!= null && !newEntry.getContent().equals("")? newEntry.getContent() : old.getContent());
//            journalEntryService.saveEntry(old);
//            return new ResponseEntity<>(old,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//}
