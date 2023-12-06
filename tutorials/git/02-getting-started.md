# Git Tutorial

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
