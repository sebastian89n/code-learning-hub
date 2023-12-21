# Git

Git is a distributed version control system that helps developers track changes to their code, collaborate with others,
and manage project history. It provides a way to save different versions of your code, making it easy to work on new
features or fix issues without breaking the existing codebase.

## Section 1: Core Concepts

### Version Control

Version control is a system that keeps track of changes to files over time. It allows you to:

- **Track Changes:** See what changes were made, who made them, and when.
- **Collaborate:** Work with others on the same project and merge changes seamlessly.
- **Revert Changes:** Go back to a previous state of your project.
- **Maintain History:** Keep a detailed history of all changes made to your code.

### Git Terminology

Before diving into Git commands, let's understand some essential terms:

- **Repository (Repo):** A repository is like a project's folder. It contains all your project's files and their
  history.

- **Commit:** A commit is a snapshot of the changes you've made to your code. It's like saving a checkpoint in your
  project's history.

- **HEAD:** Head is a reference to the most recent commit in the current branch.

- **Branch:** A branch is a separate line of development within a repository. You can create branches to work on new
  features or bug fixes without affecting the main codebase.

- **Remote:** A remote is a copy of your repository stored on a server, often on a platform like GitHub or GitLab.

- **Pull Request (PR):** A pull request is a way to propose changes from your branch to the main project. It's commonly
  used in collaborative workflows.

- **Merge:** Merging is the process of combining changes from one branch into another.

### Why Use Git?

Git offers several advantages:

- **Collaboration:** Multiple developers can work on the same project simultaneously without conflicts.

- **History Tracking:** You can track changes over time, providing transparency and accountability.

- **Branching:** Create branches to experiment with new features or fix bugs without affecting the main codebase.

- **Remote Repositories:** Store your code on remote servers for backup and collaboration.

- **Open Source:** Git is open source and widely used, with extensive documentation and community support.

## Section 2: Getting Started with Git

### Initializing new local repository

Before you can start using Git, you need to initialize a local repository. Follow these steps:

1. Open your terminal or command prompt.

2. Navigate to the root directory of your project using the `cd` command.

3. Use the following command to initialize a Git repository:

```bash
git init
```

This command creates a hidden `.git` directory in your project's root folder, which stores all the version control
information.

### Cloning existing remote repository(HTTPS/SSH):

You can also clone already existing remote repository to your local machine:

```bash
git clone repository_url
```

e.g.

```bash
git clone https://github.com/sebastian89n/code-learning-hub.git
```

```bash
git clone git@github.com:sebastian89n/code-learning-hub.git
```

### Configuring Git

Configuring Git is essential to identify yourself as the author of commits. Set your name and email using the following
commands:

1. Set your name:

```bash
git config --global user.name "Your Name"
```

2. Set your email:

```bash
git config --global user.email "youremail@example.com"
```

Replace "Your Name" and "youremail@example.com" with your actual name and email address. The `--global` flag ensures
that these settings apply to all your Git repositories.

3. Display current git configuration

```bash
git config -l
```

### Git ignore

You can specify files and directories that Git should ignore using a .gitignore file. This is useful for excluding
generated files, logs, and more. Here's how you create a .gitignore file:

1. Create a file named `.gitignore` in your project's root directory.
2. Specify patterns for files or directories to ignore. For example:

```
# Ignore log files
*.log

# Ignore the "build" directory
/build/
```

## Section 3: Basic Workflow and Understanding Local Branches in Git

Now that you have a Git repository set up, let's explore the basic Git workflow:

- **Staging Changes:**

  To stage changes for the next commit, use:

  ```bash
  git add file1.txt file2.txt
  ```

  To stage all changes, use:

  ```bash
  git add .
  ```

- **Check the status of your repository:**
  ```bash
  git status

- **Committing Changes:**

  After staging your changes, create a commit with a message to describe what you've done:

    ```bash
    git commit -m "Your commit message"
    ```

  Make sure to replace "Your commit message" with a brief, descriptive message that explains the purpose of the commit.

### Local Branches

**Local branches** are branches that exist on your local machine. They are used for development and are entirely under
your control. Some key points about local branches include:

- Local branches are stored in your local Git repository.
- You can create, delete, and switch between local branches as needed.
- Local branches are typically used for feature development, bug fixes, and other work in progress.
- Changes made to local branches are not visible to others until you push those changes to a remote repository.

Local branches are internally stored in `.git/refs/heads`

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

### Commit history

- **Viewing Commit History:**

  To see the commit history of your project, use:

    ```bash
    git log
    ```

  This displays a list of commits, including their unique hash, author, date, and commit message.

  There are optional parameters to customize log output:

    ```bash
    git log --pretty=oneline
    ```

    ```bash
    git log --pretty=oneline --since="2023-01-01" --until="2023-09-12" --author="John Smith"
    ```

  To display last x revisions use:

    ```bash
    git log --pretty=oneline -5
    ```

  To check current contributors to the project use:

    ```bash
    git shortlog -s -n
    ```

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
  To establish an upstream connection, use the following command, where `local-branch` is your local branch
  and `remote-branch` is the branch on the remote repository (typically origin):

  ```bash
  git branch -vv
  ```

## Section 5: Advanced Git Commands

### Undoing changes

Sometimes, you may need to undo changes in Git. Here are a few commands to help with that:

- **Discard changes in the working directory that are not staged(when git add was not executed on the file):**
  ```bash
  git checkout -- file_name
  ```

- **Unstage changes (undo a git add):**
  ```bash
  git reset HEAD file_name
  ```

- **Discard all uncommited changes(including staged ones) :**
  ```bash
  git reset --hard
  ```

- **Reset changes to specific commit(commit-hash is displayed in git log command):**
  ```bash
  git reset --hard commit_hash
  ```
  e.g.
  ```bash
  git reset --hard e451b29
  ```
  or reset to **n** commit before HEAD
  ```bash
  git reset --hard HEAD@{n}
  ```
  e.g. reset to one commit before current HEAD
  ```bash
  git reset --hard HEAD@{1}
  ```

- **Git Clean :** used to remove untracked files and directories from your working directory. Be cautious when
  using this command, as it permanently deletes untracked data.

  Remove untracked files and directories:
  ```bash
  git clean -f
  ```
  Remove untracked files, directories, and their contents (use with caution):
  ```bash
  git clean -f -d
  ```

- **Amend the last commit (change commit message or add more changes):**
  ```bash
  git commit --amend
  ```

### Git Reflog

`git reflog` is a valuable Git command used for tracking and managing your Git history, especially in scenarios where
you need to recover lost commits, branches, or understand reference changes.

It displays a detailed history of the "tips" of branches and other references in your Git repository. Each entry in the
reflog includes a commit's SHA-1
hash, the action taken, and a reference's name.

This command will display a list of recent reference changes, typically including branch updates, commits, merges, and
other Git actions:

  ```bash
  git reflog
  ```

Suppose you accidentally delete a branch, and you want to recover it:

- First, run git reflog to find the SHA-1 hash of the lost branch's tip.
- Then, create a new branch from that commit:
  ```bash
  git branch new_branch_name recovered_commit_hash
  ```

### Git Rebase

Rebasing is a powerful feature for cleaning up and streamlining your commit history. Here are some essential Git rebase
commands:

- **Rebase the current branch onto another branch:**

  ```bash
  git rebase target_branch
  ```

- **Interactive rebase:**

  This allows you to squash commits, reorder them, or edit commit messages interactively:

  ```bash
  git rebase -i HEAD~n
  ```
  Replace n with the number of commits you want to include in the interactive rebase

`git rebase` is a command that modifies your commit history by rewriting it. Be careful when using it:

- **Use on Feature Branches**: It's safer to use on feature branches or branches you're working on alone.

- **Avoid Shared Branches**: Avoid rebasing on shared branches to prevent conflicts and confusion.

- **Resolve Conflicts**: Carefully resolve conflicts that may arise during the rebase.

- **Inform Your Team**: If rebasing shared branches, communicate changes with your team.

- **Backup Before Rebasing**: Create backups or snapshots before starting a rebase for safety.

- **Interactive Rebasing**: Use `git rebase -i` for interactive changes like squashing or editing commits.

- **Maintain Clean History**: Use rebase to keep a clean, linear commit history.

With care and understanding, `git rebase` can help you maintain an organized Git history.

### Git Stash

The git stash command allows you to save changes that you're not ready to commit but need to switch branches or perform
other tasks. Here are some stash commands:

- **Stash your changes:**
  ```bash
  git stash save "Your stash message"
  ```
  Replace "Your stash message" with a descriptive message.


- **Apply the latest stash:**
  ```bash
  git stash apply
  ```

- **List stashes:**
  ```bash
  git stash list
  ```

- **Apply specific stash:**
  ```bash
  git stash apply "stash@{n}"
  ```
  Replace **n** with stash number. Stash numbers are displayed in the output of `git stash list` command.

  Since version 2.11 it is also possible to do the same using this command:
  ```bash
  git stash apply n
  ```

### Git Tags

Tags in Git are used to mark specific points in history, often for software releases. Here are some tag-related
commands:

- **Create a lightweight tag:**
  ```bash
  git tag tag_name
  ```

- **Create an annotated tag with a message:**
  ```bash
  git tag -a tag_name -m "Your tag message"
  ```

- **Push tags to a remote repository:**
  ```bash
  git push origin tag_name
  ```
  note: `origin` is a name of remote repository.

- **List all local tags:**
  ```bash
  git tag
  ```

### Git Cherry-Pick

Cherry-picking is the process of taking a specific commit from one branch and applying it to another. Here's how to
cherry-pick a commit:

- **Cherry-pick a commit from another branch:**
  ```bash
  git cherry-pick commit_hash
  ```

## Section 6: Git Tips & Tricks

### Aliases

Git aliases allow you to create shortcuts for commonly used Git commands. Here's how you can set up Git aliases:

1. Open your terminal or command prompt.

2. Edit your Git configuration file:

   ```bash
   git config --global --edit
   ```

Add aliases in the configuration file, for example:

```
[alias]
co = checkout
ci = commit
st = status
br = branch
```

Save and close the configuration file.

Now you can use these aliases to simplify Git commands. For example, git co instead of git checkout.

### Git Hooks

Git hooks are scripts that run automatically at specific points in the Git workflow. You can use hooks for tasks like
code linting, testing, or even custom actions. Here's how to use Git hooks:

1. Navigate to your Git repository's `.git/hooks` directory.
2. Create executable scripts with hook names (e.g., `pre-commit`, `post-merge`).
3. Customize the scripts to perform your desired actions.

Hooks provide a way to automate tasks and enforce best practices within your team.

### .gitattributes

The `.gitattributes` file is used to specify attributes for pathnames in your Git repository. It's particularly useful
for
handling line endings, merging binary files, and other repository-specific settings. For example:

```
# Set specific file to use LF line endings
*.txt text eol=lf

# Treat specific file as binary (no merging)
*.jpg binary
```

Customize your .gitattributes file to suit your project's needs.

## Section 7: Git Workflow Summary

- **Initialize a Git Repository**:
    - `git init` or `git clone`

- **Working Directory**:
    - Your project's files and folders reside here.

- **Stage Changes**:
    - `git add` to select changes for the next commit.

- **Commit Changes**:
    - `git commit` to create a snapshot with a message.

- **Branches**:
    - `git branch` to list branches and `git checkout` to switch between them.

- **Merging Changes**:
    - `git merge` to integrate changes from one branch into another.

- **Remote Repositories**:
    - Add remotes with `git remote add` and fetch changes with `git fetch`. Push with `git push`.

- **Pull Changes**:
    - Update your local repo with remote changes using `git pull`.

- **Conflict Resolution**:
    - Resolve conflicts using `git status` and a text editor, then commit.

- **Tagging**:
    - Create tags with `git tag` to mark specific points in history.

- **Git Stash** (optional):
    - Temporarily save changes with `git stash`.

- **Git History**:
    - Review commit history with `git log`.

- **Git Clean** (optional):
    - Remove untracked files with `git clean`.

These steps represent the typical Git workflow.