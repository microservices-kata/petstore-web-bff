package com.thoughtworks.petstore.web.controller;

import com.thoughtworks.petstore.web.dto.vo.request.RefundReq;
import com.thoughtworks.petstore.web.dto.vo.response.OrderDigestRes;
import com.thoughtworks.petstore.web.dto.vo.response.OrderRes;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @ApiOperation(value = "Get orders list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<OrderDigestRes>> getList(@RequestHeader(value = "User-Id") String userId) {
        return null;
    }

    @ApiOperation(value = "Get order detail")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseEntity<OrderRes> getDetail(@RequestHeader(value = "User-Id") String userId,
                              @RequestParam String id) {
        return null;
    }

    @ApiOperation(value = "Refund a pet")
    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    public ResponseEntity<OrderRes> refundPet(@RequestHeader(value = "User-Id") String userId,
                               @RequestBody RefundReq refundReq) {
        return null;
    }
}
