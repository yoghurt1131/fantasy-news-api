package dev.yoghurt1131.fantasynewsapi;

import de.flapdoodle.embed.mongo.MongoImportExecutable;
import de.flapdoodle.embed.mongo.MongoImportProcess;
import de.flapdoodle.embed.mongo.MongoImportStarter;
import de.flapdoodle.embed.mongo.config.IMongoImportConfig;
import de.flapdoodle.embed.mongo.config.MongoImportConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MongoDBImportInterceptor implements InvocationInterceptor {

    Logger LOGGER = LoggerFactory.getLogger(MongoDBImportInterceptor.class);

    @Override
    public void interceptTestMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext, ExtensionContext extensionContext) throws Throwable {
        MongoImport mongoImport = invocationContext.getExecutable().getAnnotation(MongoImport.class);
        if(mongoImport != null) {
            String filename = mongoImport.filename();
            String collection = mongoImport.collection();
            LOGGER.debug("Import test file to embedded Mongo DB. Filename={}, Collection={}", filename, collection);
            String jsonFile = "src/test/resources/" + filename;
            IMongoImportConfig mongoImportConfig = new MongoImportConfigBuilder()
                    .version(Version.Main.PRODUCTION)
                    .net(new Net(TestMongoDB.port(), Network.localhostIsIPv6()))
                    .db(TestMongoDB.dbname())
                    .collection(collection)
                    .upsert(true)
                    .dropCollection(true)
                    .jsonArray(true)
                    .importFile(jsonFile)
                    .build();
            MongoImportExecutable mongoImportExecutable = MongoImportStarter.getDefaultInstance().prepare(mongoImportConfig);
            // import execute
            MongoImportProcess mongoImportProcess = mongoImportExecutable.start();
            mongoImportProcess.stop();
            LOGGER.debug("Import finished.");
        }
        InvocationInterceptor.super.interceptTestMethod(invocation, invocationContext, extensionContext);
    }
}
