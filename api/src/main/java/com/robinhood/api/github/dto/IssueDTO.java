package com.robinhood.api.github.dto;

import com.google.gson.annotations.SerializedName;


public class IssueDTO {
    private String body;

    @SerializedName("labels")
    private LabelDTO[] labels;

    private String state;

    private AssigneeDTO assignee;

    private int number;

    private ClosedByDTO closed_by;

    private String url;

    private MilestoneDTO milestone;

    private String html_url;

    private int id;

    private String title;

    private String updated_at;

    private String repository_url;

    private PullRequestDTO pull_request;

    private String comments_url;

    private String created_at;

    private String events_url;

    private String labels_url;

    private String locked;

    private UserDTO user;

    private String comments;

    public String getBody ()
    {
        return body;
    }

    public void setBody (String body)
    {
        this.body = body;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public int getNumber ()
    {
        return number;
    }

    public void setNumber (int number)
    {
        this.number = number;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getHtml_url ()
    {
        return html_url;
    }

    public void setHtml_url (String html_url)
    {
        this.html_url = html_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getRepository_url ()
    {
        return repository_url;
    }

    public void setRepository_url (String repository_url)
    {
        this.repository_url = repository_url;
    }

    public String getComments_url ()
    {
        return comments_url;
    }

    public void setComments_url (String comments_url)
    {
        this.comments_url = comments_url;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getEvents_url ()
    {
        return events_url;
    }

    public void setEvents_url (String events_url)
    {
        this.events_url = events_url;
    }

    public String getLabels_url ()
    {
        return labels_url;
    }

    public void setLabels_url (String labels_url)
    {
        this.labels_url = labels_url;
    }

    public String getLocked ()
    {
        return locked;
    }

    public void setLocked (String locked)
    {
        this.locked = locked;
    }

    public UserDTO getUser ()
    {
        return user;
    }

    public void setUser (UserDTO user)
    {
        this.user = user;
    }

    public String getComments ()
    {
        return comments;
    }

    public void setComments (String comments)
    {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "IssueDTO{" +
                "body='" + body + '\'' +
                ", state='" + state + '\'' +
                ", number='" + number + '\'' +
                ", url='" + url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", repository_url='" + repository_url + '\'' +
                ", comments_url='" + comments_url + '\'' +
                ", created_at='" + created_at + '\'' +
                ", events_url='" + events_url + '\'' +
                ", labels_url='" + labels_url + '\'' +
                ", locked='" + locked + '\'' +
                ", user=" + user +
                ", comments='" + comments + '\'' +
                '}';
    }


    /**
     * {
     "id": 1,
     "url": "https://api.github.com/repos/octocat/Hello-World/issues/1347",
     "repository_url": "https://api.github.com/repos/octocat/Hello-World",
     "labels_url": "https://api.github.com/repos/octocat/Hello-World/issues/1347/labels{/name}",
     "comments_url": "https://api.github.com/repos/octocat/Hello-World/issues/1347/comments",
     "events_url": "https://api.github.com/repos/octocat/Hello-World/issues/1347/events",
     "html_url": "https://github.com/octocat/Hello-World/issues/1347",
     "number": 1347,
     "state": "open",
     "title": "Found a bug",
     "body": "I'm having a problem with this.",
     "user": {
     "login": "octocat",
     "id": 1,
     "avatar_url": "https://github.com/images/error/octocat_happy.gif",
     "gravatar_id": "",
     "url": "https://api.github.com/users/octocat",
     "html_url": "https://github.com/octocat",
     "followers_url": "https://api.github.com/users/octocat/followers",
     "following_url": "https://api.github.com/users/octocat/following{/other_user}",
     "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
     "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
     "subscriptions_url": "https://api.github.com/users/octocat/subscriptions",
     "organizations_url": "https://api.github.com/users/octocat/orgs",
     "repos_url": "https://api.github.com/users/octocat/repos",
     "events_url": "https://api.github.com/users/octocat/events{/privacy}",
     "received_events_url": "https://api.github.com/users/octocat/received_events",
     "type": "User",
     "site_admin": false
     },
     "labels": [
     {
     "id": 208045946,
     "url": "https://api.github.com/repos/octocat/Hello-World/labels/bug",
     "name": "bug",
     "color": "f29513",
     "default": true
     }
     ],
     "assignee": {
     "login": "octocat",
     "id": 1,
     "avatar_url": "https://github.com/images/error/octocat_happy.gif",
     "gravatar_id": "",
     "url": "https://api.github.com/users/octocat",
     "html_url": "https://github.com/octocat",
     "followers_url": "https://api.github.com/users/octocat/followers",
     "following_url": "https://api.github.com/users/octocat/following{/other_user}",
     "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
     "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
     "subscriptions_url": "https://api.github.com/users/octocat/subscriptions",
     "organizations_url": "https://api.github.com/users/octocat/orgs",
     "repos_url": "https://api.github.com/users/octocat/repos",
     "events_url": "https://api.github.com/users/octocat/events{/privacy}",
     "received_events_url": "https://api.github.com/users/octocat/received_events",
     "type": "User",
     "site_admin": false
     },
     "milestone": {
     "url": "https://api.github.com/repos/octocat/Hello-World/milestones/1",
     "html_url": "https://github.com/octocat/Hello-World/milestones/v1.0",
     "labels_url": "https://api.github.com/repos/octocat/Hello-World/milestones/1/labels",
     "id": 1002604,
     "number": 1,
     "state": "open",
     "title": "v1.0",
     "description": "Tracking milestone for version 1.0",
     "creator": {
     "login": "octocat",
     "id": 1,
     "avatar_url": "https://github.com/images/error/octocat_happy.gif",
     "gravatar_id": "",
     "url": "https://api.github.com/users/octocat",
     "html_url": "https://github.com/octocat",
     "followers_url": "https://api.github.com/users/octocat/followers",
     "following_url": "https://api.github.com/users/octocat/following{/other_user}",
     "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
     "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
     "subscriptions_url": "https://api.github.com/users/octocat/subscriptions",
     "organizations_url": "https://api.github.com/users/octocat/orgs",
     "repos_url": "https://api.github.com/users/octocat/repos",
     "events_url": "https://api.github.com/users/octocat/events{/privacy}",
     "received_events_url": "https://api.github.com/users/octocat/received_events",
     "type": "User",
     "site_admin": false
     },
     "open_issues": 4,
     "closed_issues": 8,
     "created_at": "2011-04-10T20:09:31Z",
     "updated_at": "2014-03-03T18:58:10Z",
     "closed_at": "2013-02-12T13:22:01Z",
     "due_on": "2012-10-09T23:39:01Z"
     },
     "locked": false,
     "comments": 0,
     "pull_request": {
     "url": "https://api.github.com/repos/octocat/Hello-World/pulls/1347",
     "html_url": "https://github.com/octocat/Hello-World/pull/1347",
     "diff_url": "https://github.com/octocat/Hello-World/pull/1347.diff",
     "patch_url": "https://github.com/octocat/Hello-World/pull/1347.patch"
     },
     "closed_at": null,
     "created_at": "2011-04-22T13:33:48Z",
     "updated_at": "2011-04-22T13:33:48Z",
     "closed_by": {
     "login": "octocat",
     "id": 1,
     "avatar_url": "https://github.com/images/error/octocat_happy.gif",
     "gravatar_id": "",
     "url": "https://api.github.com/users/octocat",
     "html_url": "https://github.com/octocat",
     "followers_url": "https://api.github.com/users/octocat/followers",
     "following_url": "https://api.github.com/users/octocat/following{/other_user}",
     "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
     "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
     "subscriptions_url": "https://api.github.com/users/octocat/subscriptions",
     "organizations_url": "https://api.github.com/users/octocat/orgs",
     "repos_url": "https://api.github.com/users/octocat/repos",
     "events_url": "https://api.github.com/users/octocat/events{/privacy}",
     "received_events_url": "https://api.github.com/users/octocat/received_events",
     "type": "User",
     "site_admin": false
     }
     }
     */
}
