package org.magmax.autostate;

import java.io.File;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.flywaydb.core.Flyway;

import org.magmax.autostate.Status;


public class StatusTest {
    Status status;
    File file = new File("./test.derby");

    @Before
    public void SetUp () throws Exception  {
        String connectionString = "jdbc:derby:" + file.getAbsolutePath() + ";create=true";

        Flyway flyway = new Flyway();
        flyway.setDataSource(connectionString, "", "");
        flyway.migrate();

        status = new Status(connectionString);
    }

    @After
    public void TearDown () throws Exception {
        file.delete();
    }

    @Test
    public void retrieveProjectWithEmptyDatabase() {

    }
}
