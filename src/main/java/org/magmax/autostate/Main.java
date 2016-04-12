package org.magmax.autostate;

import ratpack.server.RatpackServer;

import java.io.File;

import org.magmax.autostate.Status;


public class Main {
    public static void main(String... args) throws Exception {
        File file = new File("./autostate.derby");
        String connectionString = "jdbc:derby:" + file.getAbsolutePath();
        Status status = new Status(connectionString);
        RatpackServer.start(
            server -> server
            .handlers(chain -> chain
                 .post(":project/status/:status", ctx -> {
                         String project = ctx.getPathTokens().get("project");
                         String st = ctx.getPathTokens().get("status");
                         status.addStatus(project, st);
                         ctx.render("OK");
                     }
                 )

            )
         );
    }

}
