package allan.org.arkham_horror_app.controller;

import allan.org.arkham_horror_app.model.MythosToken;
import allan.org.arkham_horror_app.service.MythosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MythosController {

    @Autowired
    MythosService mythosService;

    @GetMapping("/mythosTokens")
    public ResponseEntity<List<MythosToken>> getAllMythosTokens() {
        return new ResponseEntity<>(mythosService.getAllMythosTokens(), HttpStatus.OK);
    }

    @GetMapping("/mythosToken/{type}")
    public ResponseEntity<MythosToken> getMythosTokenByType(@PathVariable String type) {
        return new ResponseEntity<>(mythosService.getMythosTokenByType(type), HttpStatus.OK);
    }
}
