# Git Tutorial

## Section 4: Advanced Git Commands

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
- **Amend the last commit (change commit message or add more changes):**
  ```bash
  git commit --amend
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

### Git Cherry-Pick

Cherry-picking is the process of taking a specific commit from one branch and applying it to another. Here's how to
cherry-pick a commit:

- **Cherry-pick a commit from another branch:**
  ```bash
  git cherry-pick commit_hash
  ```

### Git Submodules

Git submodules allow you to include one Git repository within another. Here's how to add and update submodules:

- **Add a submodule:**
  ```bash
  git submodule add repository_url path/to/submodule
  ```

- **Update submodules:**
  ```bash
  git submodule update --init --recursive
  ```