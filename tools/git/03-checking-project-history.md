# Checking project's history

#### Log command

```
git log
```

```
git log --pretty=oneline
```

```
git log --pretty=oneline --since="2023-01-01" --until="2023-09-12" --author="John Smith"
```

#### Display last x revisions

```
git log --pretty=oneline -5
```

#### Check current contributors to the project

```
git shortlog -s -n
```