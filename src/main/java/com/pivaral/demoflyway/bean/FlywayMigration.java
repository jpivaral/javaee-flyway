/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pivaral.demoflyway.bean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;

/**
 *
 * @author jocpi
 */
@Singleton
@Startup
@TransactionManagement(TransactionManagementType.BEAN)
public class FlywayMigration {
    
    @Resource(lookup = "java:global/MySqlDataSource")
    private DataSource dataSource;
 
    @PostConstruct
    public void init() {
        var flyway = Flyway.configure().dataSource(dataSource).load();
 
        // Needed if you want to delete existing flyway_schema_history 
        flyway.clean();
        // Needed if the database is not empty
        flyway.baseline();
 
        flyway.migrate();
    }
}
