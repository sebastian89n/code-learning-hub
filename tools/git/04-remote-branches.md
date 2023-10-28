# Git Tutorial

## Section 4: Understanding Remote Branches in Git

### Remote Branches in Git

In Git, **remote branches** represent the state of branches on a remote repository. They are used for collaboration and
tracking the work done by other team members. Some key points about remote branches include:

- Remote branches are stored in the remote repository and are read-only.
- They reflect the state of branches in the remote repository, providing visibility into what others are working on.
- Remote branches are not directly editable; they serve as references to the state of branches on the remote repository.
- You can fetch or pull changes from remote branches to keep your local repository up-to-date.

Local references are representation of all remote branches stored in your local git repository
in `.git/refs/remotes/{remoteRepoName}/`

### Remote repositories

Git enables you to collaborate with others using remote repositories.

In the examples below `origin` is a name of remote repository stored in your local git repository. A different name can
be chosen and there could be more than one remote repository configured under different names as well.

Here are some key remote repository commands:

- **Add a remote repository:**
  ```bash
  git remote add origin repository_url
  ```

- **Fetch changes from a remote repository:**

  git fetch updates your remote-tracking branches under `refs/remote/<remote>/`
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
  or to pull current branch and fetch everything other branch from remote:
  ```bash
  git pull origin
  ```

  it is equivalent of running:
    ```bash
  git fetch origin branch_name
  git merge origin/branch_name
  ```
- **Checking Out Remote Branches:**

  You can create a local version of a remote branch by checking it out. This allows you to work on a copy of the remote
  branch locally:
  ```bash
  git checkout -b local_branch_name origin/remote_branch_name
  ```

  If you want to create a local branch from remote
  one with the same name, you can just use:
  ```bash
  git checkout remote_branch_name
  ```

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