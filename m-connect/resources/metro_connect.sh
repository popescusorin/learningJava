#! /usr/bin/expect

set timeout -1
set server [lindex $argv 0]
set user [lindex $argv 1]
set password [lindex $argv 2]

#send_user "$user and $server"
spawn snx -g -s $server -u $user
match_max 100000
expect "Please enter your password:\r"
send -- "$password\r"
expect eof
