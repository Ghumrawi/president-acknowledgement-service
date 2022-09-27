package com.winsupply.pas.controllers

import com.winsupply.pas.services.As400Service
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import javax.servlet.http.HttpServletRequest

@Slf4j
@RestController
@RequestMapping("/helper")
class PasHelperController {

    @Autowired
    As400Service as400Service





    /**
     *
     * @param httpServletRequest
     * @return
     */
    @GetMapping(value = "/as400test", produces = "application/json")
    public ResponseEntity<?> testAs400Connection(HttpServletRequest httpServletRequest ){
        log.debug("testAs400Connection entered ...")

        as400Service.testConnection();
        return new ResponseEntity<>("test", HttpStatus.OK)
    }


}
