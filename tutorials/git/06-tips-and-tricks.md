# Git Tutorial

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
