package com.multiplica.talent.microservicecolors.controller;

import com.multiplica.talent.microservicecolors.mappers.dto.Colors;
import com.multiplica.talent.microservicecolors.mappers.dto.PageColorDTO;
import com.multiplica.talent.microservicecolors.service.impl.ImplColorService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;

@RestController
@RequestMapping(path = "/api/v1")
@Slf4j
public class ColorController {

    @Autowired
    private ImplColorService implColorService;

    @ApiOperation(value = "Get all Colors", consumes = "application/json",  response = PageColorDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Equipments", response = PageColorDTO.class),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") ,
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "accept", dataType = "string", paramType = "header",
                    value = "type of format of response (application/json ,application/xml), default application/json ")
    })
    @GetMapping(path = "colores")
    public ResponseEntity<Mono<?>> getColors(@Nullable Integer page, @Nullable Integer size, @RequestHeader("accept") String header) {
        return ResponseEntity.ok(this.implColorService.findAllColors(page, size));
    }

    @ApiOperation(value = "get color by Id", consumes = "application/json", response = Colors.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Equipments", response = Colors.class),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") ,
            @ApiResponse(code = 500, message = "Internal server error"),
    })
    @GetMapping(path = "colores/{id}")
    public ResponseEntity<Mono<?>> getColorById(@PathVariable("id") Integer id) {
        return   ResponseEntity.ok(this.implColorService.getById(id));
    }

    @ApiOperation(value = "create color", consumes = "application/json", response = Colors.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Equipments" , response = Colors.class),
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") ,
            @ApiResponse(code = 500, message = "Internal server error"),
    })
    @PostMapping(value = "color", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Colors> create(@RequestBody Colors colors) {
        return ResponseEntity.ok(this.implColorService.createColor(colors)).getBody();
    }
}
