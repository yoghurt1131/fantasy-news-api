package dev.yoghurt1131.fantasynewsapi;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestApplication.class)
abstract class FantasyNewsApiApplicationDBTests {

	private static MongodExecutable mongodExecutable;

	@BeforeAll
	public static void setupDB() throws Exception {
		MongodStarter mongodStarter = MongodStarter.getDefaultInstance();
		IMongodConfig mongodConfig = new MongodConfigBuilder()
				.version(Version.Main.PRODUCTION)
				.net(new Net(TestMongoDB.port(), Network.localhostIsIPv6()))
				.build();
		mongodExecutable = mongodStarter.prepare(mongodConfig);
		MongodProcess mongod = mongodExecutable.start();
	}

	@AfterAll
	public static void teardownDB() {
		mongodExecutable.stop();
	}

}
