package com.sitemate.issues.service.impl;

import com.sitemate.issues.model.Issue;
import com.sitemate.issues.repository.IssueRepository;
import com.sitemate.issues.service.IssueService;
import com.sitemate.issues.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;

    @Override
    public Issue create(Issue issue) {
//        return issueRepository.save(issue);
        return null;
    }
    @Override
    public void deleteById(Integer id){
//        issueRepository.deleteById(id);
        //it is better to use logical delete instead of physical, so in that case we should use is_deleted flag in Issue entity
    }

    @Override
    public Issue update(Issue issue) {
//        return issueRepository.save(issue);
        return null;
    }

    @Override
    public Issue getById(Integer id) {
//        Optional<Issue> issueOptional = issueRepository.findById(id);
//        return issueOptional.isPresent() ? issueOptional.get() :  getStub();
        return getStub();
    }

    public Issue getStub(){
        return new Issue(-1, Constants.defaultTitle, Constants.defaultDescription);
    }
}
