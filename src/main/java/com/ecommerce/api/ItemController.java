package com.ecommerce.api;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Item;
import com.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/count")
    public Long countItems() {

        return itemService.itemCount();
    }

    @GetMapping("/all")
    public List<Item> getAllItems() {

        return itemService.findAllItems();
    }

    @GetMapping
    public Page<Item> getAllItems(Pageable pageable) {
        return itemService.findAllItemsPageable(pageable);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity getItemById(@PathVariable Long id) {
        try {
            Item singleItem = itemService.findById(id);
            return new ResponseEntity<>(singleItem, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@Valid @RequestBody final Item item) {
        Item newItem = itemService.createItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> editItem(@PathVariable long id, @Valid @RequestBody final Item item) {
        Item existingItem = itemService.editItem(id, item);
        return new ResponseEntity<>(existingItem, HttpStatus.CREATED);
    }
}
