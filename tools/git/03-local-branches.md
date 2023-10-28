# Git Tutorial

## Section 3: Understanding Local Branches in Git

When working with Git, it's important to distinguish between **local branches** and **remote branches**. These concepts
are fundamental to version control and collaboration.

### Local Branches

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
