# Git Tutorial

## Section 3: Understanding Local and Remote Branches in Git

When working with Git, it's important to distinguish between **local branches** and **remote branches**. These concepts
are fundamental to version control and collaboration.

## Local Branches

**Local branches** are branches that exist on your local machine. They are used for development and are entirely under
your control. Some key points about local branches include:

- Local branches are stored in your local Git repository.
- You can create, delete, and switch between local branches as needed.
- Local branches are typically used for feature development, bug fixes, and other work in progress.
- Changes made to local branches are not visible to others until you push those changes to a remote repository.

Local branches are internally stored in `.git/refs/heads`

### Common Local Branch Operations

- **Creating a Local Branch:**

  To create a new local branch, use the following command:

  ```bash
  git branch branch_name
  ```

- **Switch to a branch:**
  ```bash
  git checkout branch_name
  ```

- **Create and switch to a new branch in one command:**
  ```bash
  git checkout -b new_branch_name
  ```

- **List all branches:**
  ```bash
  git branch
  ```

- **If you have a lot of branches, you can grep output that contains specific phrase or prefix:**
  ```bash
  git branch | grep phrase
  ```

- **Merge different local branch into the current branch:**
  ```bash
  git merge branch_name
  ```

## Remote Branches in Git

In Git, **remote branches** represent the state of branches on a remote repository. They are used for collaboration and
tracking the work done by other team members. Some key points about remote branches include:

- Remote branches are stored in the remote repository and are read-only.
- They reflect the state of branches in the remote repository, providing visibility into what others are working on.
- Remote branches are not directly editable; they serve as references to the state of branches on the remote repository.
- You can fetch or pull changes from remote branches to keep your local repository up-to-date.

Local references are representation of all remote branches stored in your local git repository
in `.git/refs/remotes/{remoteRepoName}/`

## Remote repositories

Git enables you to collaborate with others using remote repositories. Here are some key remote repository commands:

In the examples below `origin` is a name of remote repository stored in your local git repository. A different name can
be chosen and there could be more than one remote repository configured under different names as well.

- **Add a remote repository:**
  ```bash
  git remote add origin repository_url
  ```

- **Push a new branch to remote repository:**
  ```bash
  git push --set-upstream origin branch_name
  ```
  or simplified form:
  ```bash
  git push -u origin branch_name
  ```

- **Push changes on a branch that already exists on remote repository:**
  ```bash
  git push origin branch_name
  ```

- **Fetch changes from a remote repository:**

  git fetch updates your remote-tracking branches under `refs/remote/<remote>/`
  but it doesn't update your local branches.
  ```bash
  git fetch origin branch_name
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
- **Checking Out Remote Branches:**

  You can create a local version of a remote branch by checking it out. This allows you to work on a copy of the remote
  branch locally:
  ```bash
  git checkout -b local_branch_name origin/remote_branch_name
  ```

If you have already fetched remote branches in your local repository and you want to create a local branch from remote
one with the same name, you can just use:

  ```bash
  git checkout -b remote_branch_name
  ```

It will create a local branch called remote_branch_name.