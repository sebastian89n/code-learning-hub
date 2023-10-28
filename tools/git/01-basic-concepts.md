# Basic concepts

#### Repository (Repo):

A repository is a directory or storage space where your project lives. It contains all the files and folders that make
up your project, along with the version history.

#### Working Directory:

The working directory is the directory on your local machine where you make changes to your project. These changes are
not yet part of the Git repository.

#### Staging Area (Index):

The staging area is a buffer that holds changes you want to commit. It allows you to select which changes you want to
include in the next commit.

#### Commit:

A commit is a snapshot of your project at a specific point in time. It records changes made to the files in the staging
area. Each commit has a unique identifier (a SHA-1 hash) and a commit message to describe the changes.

#### Branch:

A branch is a separate line of development within a Git repository. It allows you to work on new features or bug fixes
independently without affecting the main project. The main branch is often called the "master" branch.

#### Checkout:

Checking out a branch means switching to a different branch or commit. It updates your working directory to reflect the
state of the branch or commit you checked out.

#### Merge:

Merging is the process of combining changes from one branch into another. This is often used to integrate feature
branches back into the main branch.

#### Pull Request (PR):

A pull request is a feature in Git hosting platforms (like GitHub) that allows you to propose changes to a repository.
It's a way to review, discuss, and merge code changes.

#### Clone:

Cloning is the process of creating a copy of a Git repository on your local machine. This is typically done to start
working on an existing project.

#### Fork:

Forking is a way to create a copy of a repository under your own account on Git hosting platforms. It's often used when
you want to contribute to an open-source project.

#### Remote:

A remote is a reference to a repository hosted on a remote server. It allows you to interact with repositories on
platforms like GitHub or GitLab.

#### Pull:

Pulling is the process of fetching changes from a remote repository and merging them into your local branch. It's often
used to keep your local repository up to date with changes made by others.

#### Push:

Pushing is the process of sending your local commits to a remote repository. It updates the remote repository with your
changes.

#### Conflict:

Conflicts occur when Git is unable to automatically merge changes from different branches. You must resolve conflicts
manually by editing the affected files.