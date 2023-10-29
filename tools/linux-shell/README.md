# Essential Linux Shell Commands for Software Developers

The Linux command-line interface is a powerful tool for software development. Here's a list of essential shell commands
that every developer should be familiar with:

## Navigation

- `cd`: Change directory.

    ```bash
    cd /path/to/directory
    ```

- `cd ..`: Change to the parent directory.

    ```bash
    cd ..
    ```

- `ls`: List files and directories.

    ```bash
    ls
    ```
    ```bash
    ls -lh
    ```

- `pwd`: Print the current working directory.

    ```bash
    pwd
    ```

## File Operations

- `cp`: Copy files and directories.

    ```bash
    cp file.txt /path/to/destination/
    ```

- `mv`: Move or rename files and directories.

    ```bash
    mv old_file.txt new_file.txt
    ```

- `rm`: Remove files.

    ```bash
    rm file_to_remove.txt
    ```

- `mkdir`: Create a new directory.

    ```bash
    mkdir new_directory
    ```

- `rmdir` or `rm -r`: Remove a directory.

    ```bash
    rm -r directory_to_remove
    ```

- `rm -rf`: Recursively and forcefully remove a directory.

    ```bash
    rm -rf directory_to_remove/
    ```

  The `rm -rf` command is used to delete a directory and its contents, including all subdirectories and files, with
  the `-r` (recursive) and `-f` (force) flags. It's a powerful command, so use it with caution. For instance, to remove
  a directory named "directory_to_remove," you would run:

    ```bash
    rm -rf directory_to_remove/
    ```

  This command will delete "directory_to_remove" and everything inside it without asking for confirmation, so be very
  careful when using it.


- `touch`: Create an empty file.

    ```bash
    touch new_file.txt
    ```

- `cat`: View the contents of a file.

    ```bash
    cat file.txt
    ```

- `more` or `less`: View file content one screen at a time.

    ```bash
    less large_file.txt
    ```

- `head`: Display the beginning of a file.

    ```bash
    head -n 10 file.txt
    ```

- `tail`: Display the end of a file.

    ```bash
    tail -n 10 file.txt
    ```

- `tail -f`: Continuously monitor a file (e.g., log files).

    ```bash
    tail -f log.txt
    ```

    ```bash
    tail -f log.txt | grep ERROR
    ```

## Text Processing

- `grep`: Search text using regular expressions.

    ```bash
    grep "pattern" file.txt
    ```

- `sed`: Stream editor for text manipulation.

    ```bash
    sed 's/old_text/new_text/g' file.txt
    ```

- `awk`: Text processing tool.

    ```bash
    awk '{ print $1 }' file.txt
    ```

- `wc`: Word, line, character, and byte count.

    ```bash
    wc file.txt
    ```
    ```bash
    grep ERROR server.logs | wc -l
    ```

## Archive and Compression

- `zip`: Create a zip archive.

    ```bash
    zip -r archive.zip directory/
    ```

  The `zip` command is used to create compressed zip archives. In this example, it creates a zip archive called "
  archive.zip" from the "directory" and its contents.


- `unzip`: Extract files from a zip archive.

    ```bash
    unzip archive.zip
    ```

  To extract files from a zip archive called "archive.zip," you can use the `unzip` command.


- `tar`: Extract files from a tar archive.

    ```bash
    tar -xvf archive.tar
    ```

  The `tar` command is used to create and manipulate tar archives. To extract files from a tar archive, you can use
  the `-x` flag, which stands for "extract," and the `-v` flag for "verbose" output. For example, to extract the
  contents of a tar archive named "archive.tar," you would run:

    ```bash
    tar -xvf archive.tar
    ```

  The command will extract all the files and directories that were archived in "archive.tar" into the current directory.
  You can specify a different destination using the `-C` flag followed by the path to the target directory:

    ```bash
    tar -xvf archive.tar -C /path/to/destination
    ```

- `gzip`: Compress a file.

    ```bash
    gzip file.txt
    ```

  The `gzip` command is used to compress files. In this example, it compresses "file.txt" into "file.txt.gz."

- `gunzip`: Decompress a gzip file.

    ```bash
    gunzip file.txt.gz
    ```

  To decompress a gzip-compressed file, you can use the `gunzip` command.

## Secure Shell (SSH) and File Transfer

- `ssh`: Secure Shell for remote access.

    ```bash
    ssh username@remote-host
    ```

  The `ssh` command is used for secure remote access to another host. Replace "username" with your username and "
  remote-host" with the hostname or IP address of the remote machine.


- `ssh`: Secure Shell for port forwarding.

    ```bash
    ssh -L local_port:destination_host:remote_port username@remote_host
    ```

  The `ssh` command can be used to create an SSH tunnel for port forwarding. In this example, we forward a local port to
  a remote port on a destination host through a remote server. Here's a breakdown of the command:

    - `-L`: Indicates local port forwarding.
    - `local_port`: The local port on your machine that you want to forward.
    - `destination_host`: The hostname or IP address of the machine where you want the traffic to be forwarded to.
    - `remote_port`: The port on the destination host.
    - `username`: Your username on the remote server.
    - `remote_host`: The hostname or IP address of the remote server you're connecting to.

  For instance, to forward local port 8080 to the remote server at 192.168.1.100 on port 80, you would use:

    ```bash
    ssh -L 8080:192.168.1.100:80 your_username@remote-server
    ```

  This command will set up port forwarding so that any traffic sent to your local machine on port 8080 will be forwarded
  to the remote server at 192.168.1.100 on port 80.


- `scp`: Securely copy files over SSH.

  Copy file to a server to specified local directory:
    ```bash
    scp local-file.txt username@remote-host:/path/to/destination/
    ```
  Copy file from a server:
    ```bash
    scp username@remote-host:/path/to/destination/remote-file.txt /local_directory
    ```
  Copy file from a server to current directory:
    ```bash
    scp username@remote-host:/path/to/destination/remote-file.txt .
    ```

## Process Management

- `ps`: Display information about running processes.

    ```bash
    ps
    ```

  The `ps` command is used to display a list of currently running processes on your system. By default, it shows a
  minimal set of information about processes.

- `ps aux`: Display detailed information about running processes.

    ```bash
    ps aux
    ```

  To view more detailed information about running processes, you can use the `ps aux` command. It provides a
  comprehensive list of processes with details like user, CPU usage, memory usage, and more.

- `top`: Interactive process viewer.

    ```bash
    top
    ```

  The `top` command is an interactive process viewer that provides real-time information about system processes. It
  displays a dynamic list of running processes and system statistics. You can exit `top` by pressing `q`.

  Additionally, you can use specific options with `top` to sort and filter processes. For example, to sort processes by
  CPU usage, run:

    ```bash
    top -o %CPU
    ```

  To filter processes by a specific user, use:

    ```bash
    top -u username
    ```

  You can explore more options by pressing the `h` key while in `top`


- `nohup`: Run a command immune to hang-ups.

    ```bash
    nohup your_command &
    ```

  The `nohup` command is used to run a command in such a way that it is immune to hang-ups, allowing it to continue
  running even if you log out or close the terminal. The `&` at the end of the command is used to run the process in the
  background.

  For example, to run a script called "myscript.sh" in the background and detach it from the terminal, you would run:

    ```bash
    nohup ./myscript.sh &
    ```

  This command will start "myscript.sh" and continue running it even if you log out of the system.

  You can check the output of the background process in a file called `nohup.out` in the same directory where you ran
  the `nohup` command.

## Networking and Data Transfer

- `curl`: Transfer data with URLs.

    ```bash
    # Make a simple GET request to a URL
    curl https://www.example.com

    # Save the response to a file
    curl -o output.html https://www.example.com

    # Follow redirects and save the final page to a file
    curl -L -o output.html https://www.example.com

    # Send data in a POST request
    curl -X POST -d "param1=value1&param2=value2" https://www.example.com/api

    # Download a file
    curl -O https://www.example.com/file.txt

    # Resume a download
    curl -C - -O https://www.example.com/large-file.zip
    ```

  The `curl` command is a versatile tool for making HTTP requests and transferring data. Here are some common use cases:

    - Making a simple GET request to a URL.
    - Saving the response to a file with the `-o` option.
    - Following redirects with the `-L` option.
    - Sending data in a POST request with the `-d` option.
    - Downloading a file with the `-O` option.
    - Resuming a download with the `-C` option.

  You can use `curl` for various tasks, such as accessing web APIs, downloading files, and more.


- `wget`: Download a file from the internet.

    ```bash
    wget https://www.example.com/file.txt
    ```

  The `wget` command is used to download files from the internet via HTTP, HTTPS, or FTP. In this example, we are
  downloading a file called "file.txt" from the specified URL (https://www.example.com).

  By running the command:

    ```bash
    wget https://www.example.com/file.txt
    ```

  `wget` will retrieve the file and save it in the current directory.

  You can also specify a different destination for the downloaded file using the `-P` flag:

    ```bash
    wget -P /path/to/save https://www.example.com/file.txt
    ```

  This will download "file.txt" and save it in the specified directory.

## System Information

- `date`: Display the current date and time.

    ```bash
    date
    ```

  The `date` command is used to display the current date and time. Running this command will provide you with the
  current date and time in your system's configured format.

- `df`: Display disk space usage.

    ```bash
    df -h
    ```

  The `df` command is used to display disk space usage. The `-h` flag provides human-readable output, making it easier
  to understand. This command will show you information about the disk space used and available on your system's file
  systems.

  You can also specify a particular directory or disk to check, for example:

    ```bash
    df -h /path/to/directory
    ```

  This command will display the disk space usage for the specified directory.

## Java Development Tools

- `jstack`: Obtain a Java thread dump. Use ps -aux to find process ID(pid)

    ```bash
    ps aux | grep java
    jstack <pid>
    ```

  The `jstack` command is used to obtain a Java thread dump of a running Java process. You need to provide the process
  ID (PID) of the Java application as an argument. For example, to obtain a thread dump for a Java process with PID
  12345, you would run:

    ```bash
    jstack 12345
    ```
    ```bash
    jstack 12345 > thread_dump.txt
    ```

  The `jstack` command is especially useful for diagnosing issues related to thread deadlock, high CPU usage, or other
  performance problems in a Java application. The thread dump provides information about the state of each thread,
  including what they are currently doing and their call stack.

## Data Integrity

- `md5sum`: Calculate the MD5 checksum of a file and save it to a file.

    ```bash
    md5sum file.txt > file.txt.md5sum
    ```

  The `md5sum` command is used to calculate the MD5 checksum of a file. In this example, we save the MD5 checksum to a
  file named "file.txt.md5sum." This saved checksum file can be used for later verification of the file's integrity.

- `md5sum -c`: Check the MD5 checksum using a saved checksum file.

    ```bash
    md5sum -c file.txt.md5sum
    ```

  To verify the integrity of a file using the saved MD5 checksum, you can use the `md5sum -c` command. This command
  checks the file's checksum against the checksum saved in "file.txt.md5sum."

  If the file hasn't been tampered with, you will receive an output like "file.txt: OK." If there's a discrepancy, you
  will be alerted to it.

  The combination of these commands ensures that a file's integrity can be checked at a later time.