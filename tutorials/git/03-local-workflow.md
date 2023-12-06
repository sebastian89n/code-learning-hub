# Git Tutorial

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