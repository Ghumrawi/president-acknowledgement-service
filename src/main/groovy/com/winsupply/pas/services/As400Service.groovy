package com.winsupply.pas.services

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.transaction.annotation.Transactional

import java.sql.ResultSet
import java.sql.SQLException

@Transactional
@Slf4j
@Service
class As400Service {

    @Autowired
    @Qualifier("as400JdbcTemplate")
    JdbcTemplate as400JdbcTemplate




    def void testConnection(){
        log.debug("as400 testConnection entered ..")
        try{
            String winId = "009085";
            String query = "select * from BENLIB.OEEMPLPF where OEWINID='${winId}'"
            Object lastName = as400JdbcTemplate.queryForObject(query, this.getTestRowMapper() )
            log.debug("last name -> " + lastName)
        }catch( EmptyResultDataAccessException e){
            //-- when no result found .. return null????
            log.error("Exception in testConnection- ", e)
            //e.printStackTrace()
        }
    }
    private RowMapper<String> getTestRowMapper() {
        RowMapper<String> rowMapper = new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                log.debug("we are on to something ......")
                String ln = rs.getString("OEEMPLN")
                //logger.debug("last name ===> " + ln)
                return ln
            }
        }
        return rowMapper
    }


}
