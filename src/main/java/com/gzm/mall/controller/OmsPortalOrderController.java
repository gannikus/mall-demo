package com.gzm.mall.controller;

import com.gzm.mall.dto.OrderParam;
import com.gzm.mall.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理Controller
 *
 * @author gzm
 * @Date 2020/06/24 16:33
 */
@RestController("OmsPortalOrderController.v1")
@Api(tags = "OmsPortalOrderController",description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("根据购物车信息生成订单")
    @PostMapping(value = "/generateOrder")
    @ResponseBody
    public Object generateOrder(@RequestBody OrderParam orderParam) {
        return portalOrderService.generateOrder(orderParam);
    }
}
