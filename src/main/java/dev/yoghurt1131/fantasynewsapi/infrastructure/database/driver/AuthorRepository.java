package dev.yoghurt1131.fantasynewsapi.infrastructure.database.driver;

import dev.yoghurt1131.fantasynewsapi.infrastructure.database.input.AuthorDbRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AuthorRepository extends CrudRepository<AuthorDbRecord, UUID> {


}
