package com.sitemate.issues.service;

import com.sitemate.issues.model.Issue;

import java.util.List;

public interface IssueService {
    Issue create(Issue issue);

    Issue getById(Integer id);

    void deleteById(Integer id);

    Issue update(Issue issue);
}
