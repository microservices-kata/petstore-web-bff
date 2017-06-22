package com.thoughtworks.petstore.web.controller;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.petstore.web.dto.request.BuyReq;
import com.thoughtworks.petstore.web.dto.response.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @ApiOperation(value = "Get categories list")
    @RequestMapping(value = "/categories/list", method = RequestMethod.GET)
    public ResponseEntity<List<CategorieRes>> getCategoriesList() {
        return ResponseEntity.status(HttpStatus.OK).body(
                ImmutableList.of(
                    new CategorieRes("0001", "Cat", "", ""),
                    new CategorieRes("0002", "Dog", "", ""),
                    new CategorieRes("0003", "Rabbit", "", "")
        ));
    }

    @ApiOperation(value = "Get species list")
    @RequestMapping(value = "/species/list", method = RequestMethod.GET)
    public ResponseEntity<List<SpeciesRes>> getSpeciesList(@RequestParam String categoryId) {
        return null;
    }

    @ApiOperation(value = "Get pets list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<PetDigestRes>> getList(@RequestParam String speciesId) {
        return null;
    }

    @ApiOperation(value = "Get pet detail")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseEntity<PetRes> getDetail(@RequestParam String petId) {
        return null;
    }

    @ApiOperation(value = "Buy a pet")
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public ResponseEntity<OrderDigestRes> buyPet(@RequestHeader(value = "User-Id") String userId,
                             @RequestBody BuyReq buyReq) {
        return null;
    }
}
