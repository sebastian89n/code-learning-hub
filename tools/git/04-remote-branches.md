# Git Tutorial

## Section 4: Understanding Remote Branches in Git

When working with Git, it's important to distinguish between **local branches** and **remote branches**. These concepts
are fundamental to version control and collaboration.

### Remote Branches in Git

In Git, **remote branches** represent the state of branches on a remote repository. They are used for collaboration and
tracking the work done by other team members. Some key points about remote branches include:

- Remote branches are stored in the remote repository and are read-only.
- They reflect the state of branches in the remote repository, providing visibility into what others are working on.
- Remote branches are not directly editable; they serve as references to the state of branches on the remote repository.
- You can fetch or pull changes from remote branches to keep your local repository up-to-date.

Local references are representation of all remote branches stored in your local git repository
in `.git/refs/remotes/{remoteRepoName}/`

### Remote repositories and branches

Git enables you to collaborate with others using remote repositories.

In the examples below `origin` is a name of remote repository stored in your local git repository. A different name can
be chosen and there could be more than one remote repository configured under different names as well.

Here are some key remote repository commands:

- **Add a remote repository:**
  ```bash
  git remote add origin repository_url
  ```

- **Fetch changes from a remote repository:**

  git fetch updates your remote-tracking branches under `.git/refs/remotes/{remoteRepoName}/`
  but it doesn't update your local branches.
  ```bash
  git fetch origin branch_name
  ```
  or to fetch every branch from remote repository:
  ```bash
  git fetch origin
  ```

- **Pull changes from a remote repository:**

  git pull brings current local branch up to date with its remote version
  ```bash
  git pull origin branch_name
  ```
  it is equivalent of running:
    ```bash
  git fetch origin branch_name
  git merge origin/branch_name
  ```  

  or to pull current branch and fetch everything other branch from remote:
  ```bash
  git pull origin
  ```
  it is equivalent of running:
    ```bash
  git fetch origin
  git merge origin/current_branch_name
  ```  

- **Checking Out Remote Branches:**

  If a branch `remote_branch_name` do not exist in your local branches, but it exists in the remote branches,
  you can create a new local branch with the same name and set upstream to remote branch by using:
  ```bash
  git checkout remote_branch_name
  ```

  You can also create a local branch from a remote branch with a different name by using:
  ```bash
  git checkout -b local_branch_name origin/remote_branch_name
  ```

  Commands above create a local branch from remote one and set upstream to that branch.

- **Push a new branch to remote repository:**
  ```bash
  git push --set-upstream origin branch_name
  ```
  or simplified form:
  ```bash
  git push -u origin branch_name
  ```

- **Push changes on a branch that already exists on remote repository(local branch needs to have correctly configured
  upstream to remote branch):**
  ```bash
  git push origin branch_name
  ```

### Connecting Local and Remote Branches via Upstream

In Git, a local branch can be associated with a remote branch through an "upstream" relationship. This connection allows
for easier tracking and synchronization between your local and remote repositories.

- **Set Upstream Branch:**
  To establish an upstream connection, use the following command, where `local-branch` is your local branch
  and `remote-branch` is the branch on the remote repository (typically origin):

  ```bash
  git branch --set-upstream-to=origin/remote-branch local-branch
  ```

  It is done automatically if you checkout remote branch on your local repository(create a local branch from existing
  remote branch).


- **View Upstream Configuration:**
  ```bash
  git branch -vv
  ```