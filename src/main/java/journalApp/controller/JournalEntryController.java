//start -1
//package journalApp.controller;
//
//import journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//
//    private Map<Long,JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//     public List<JournalEntry> getAll(){
//     return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntries.put(myEntry.getId(),myEntry);
//        return true;
//    }
//    @GetMapping("id/{myId}")
//    public JournalEntry getById(@PathVariable Long myId){
//        return journalEntries.get(myId);
//    }
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteById(@PathVariable Long myId){
//        return journalEntries.remove(myId);
//    }
//    @PutMapping("/id/{myId}")
//    public JournalEntry updateById(@PathVariable Long id,@RequestBody JournalEntry myEntry) {
//        return journalEntries.put(id,myEntry);
//    }
//}
