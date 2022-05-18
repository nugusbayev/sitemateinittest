package com.sitemate.issues.controller;

import com.sitemate.issues.model.Issue;
import com.sitemate.issues.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class IssueController {
    static final String ISSUES = "/issues";
    static final String ISSUES_ID = ISSUES+"/{id}";
    private final IssueService issueService;

    static final Logger log = LoggerFactory.getLogger(IssueController.class);
    @PostMapping(
            value = ISSUES,
            name="create",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Issue>  create(@RequestBody Issue issue){
        issueService.create(issue);
        log.info("Created issue:" + issue.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(
            value = ISSUES_ID,
            name = "get one by id"
    )
    public ResponseEntity<Issue> getById(@PathVariable Integer id){
        Issue issue = issueService.getById(id);
        return new ResponseEntity<Issue>(issue, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = ISSUES_ID,
            name = "delete by id"
    )
    public ResponseEntity<Issue> delete(@PathVariable Integer id){
//        issueService.deleteById(id);
        log.info("deleted issue with id: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(
            method = RequestMethod.PUT,
            value = ISSUES_ID,
            name = "update by id"
    )
    public ResponseEntity<Issue> update(@RequestBody Issue issue){
        issueService.update(issue);
        log.info("Updated issue:" + issue.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
