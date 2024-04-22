package inv;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.List;

    @Controller
    public class InventoryRestController {
        private final InventoryService inventoryService;
        @GetMapping("home")
        public String h(){
            return "home";
        }
        @GetMapping("login")
        public String log() {
            return "home";
        }

        public InventoryRestController(InventoryService inventoryService) {
            this.inventoryService = inventoryService;
        }

        @GetMapping("edit1")
        public String get(Model model) {
            model.addAttribute("Inventory", this.inventoryService.catg1());
            return "home";
        }

        @RequestMapping("edit2")
        public String get1(Model m1) {
            m1.addAttribute("Inventory", this.inventoryService.catg2());
            return "home";
        }
        @RequestMapping("edit3")
        public String get33(Model m33) {
            m33.addAttribute("Inventory", this.inventoryService.catg33());
            return "home";
        }
        @RequestMapping("edit4")
        public String get44(Model m44) {
            m44.addAttribute("Inventory", this.inventoryService.catg44());
            return "home";
        }
        @RequestMapping("about")
        public String about(){
            return "about";
        }
        @RequestMapping("edit55")
        public String get55(Model m55) {
            m55.addAttribute("Inventory", this.inventoryService.catg55());
            return "home";
        }

        // @GetMapping
        //  public List<Inventory> getAll() {
        //      return this.inventoryService.getAllItems();
        //  }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public String create(
                @RequestBody Inventory item
        ) {
            return this.inventoryService.createNewItem(item);
        }



        @GetMapping("orders/edit3")
        public String getcreateform() {
            return "new-order";
        }
        @PostMapping("delete/post")
        public String deleteOrder(
                @RequestParam("id") String id
        ) {
            return this.inventoryService.deleteOrder(Integer.parseInt(id));
        }
        @PostMapping("inc1")
        public String inc(@RequestParam("inv_id") String id){
            return this.inventoryService.incrementCount(Integer.parseInt(id));
        }
        @PostMapping("desc")
        public String desc(@RequestParam("desc_id") String id){
            return this.inventoryService.descrementCount(Integer.parseInt(id));
        }
        @PostMapping("add/post")
        public String trandb(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("category_id") String category_id,
                             @RequestParam("price") String price,
                             @RequestParam("description") String description,
                             @RequestParam("count") String count) {

            return this.inventoryService.CreateNewItem(Integer.parseInt(id), name, Integer.parseInt(category_id), Integer.parseInt(price), description, Integer.parseInt(count));
        }

        @PostMapping("update/post")
        public String trandbc(@RequestParam("id") String id,
                              @RequestParam("name") String name,
                              @RequestParam("category_id") String category_id,
                              @RequestParam("price") String price,
                              @RequestParam("description") String description,
                              @RequestParam("count") String count) {

            return this.inventoryService.UpdateItem(Integer.parseInt(id), name, Integer.parseInt(category_id), Integer.parseInt(price), description, Integer.parseInt(count));

        }

    }


