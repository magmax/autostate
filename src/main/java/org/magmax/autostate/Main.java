package org.magmax.autostate;

import ratpack.server.RatpackServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.File;

public class Main {
    public static void main(String... args) throws Exception {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        File file = new File("./autostate.derby");
        Connection conn = DriverManager.getConnection("jdbc:derby:" + file.getAbsolutePath() + ";create=true");
        RatpackServer.start(
            server -> server
            .handlers(chain -> chain
               .post(":project/status/:status", ctx -> ctx.render("OK"))
            )
         );
    }
}
