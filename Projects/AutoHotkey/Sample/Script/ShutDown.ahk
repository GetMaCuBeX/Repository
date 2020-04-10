#KeyHistory, 0					; Disable key history.
#MaxThreadsPerHotkey, 1 		; No re-entrant hotkey handling.
; #NoTrayIcon
Menu, Tray, Icon, main.cpl, 3
#NoEnv                          ; Recommended for performance and compatibility with future AutoHotkey releases.
#Persistent                     ; Prevent the script from exiting automatically.
#SingleInstance force           ; Skips the dialog box and replaces the old instance automatically, which is similar in effect to the Reload command.
; #SingleInstance ignore 		; Skips the dialog box and leaves the old instance running. In other words, attempts to launch an already-running script are ignored.
; #SingleInstance off 			; Allows multiple instances of the script to run concurrently.
#UseHook
#Warn 			     			; Enable warnings to assist with detecting common errors.
; #Warn , ,MsgBox               	; Show a message box describing the warning. Note that once the message box is dismissed, the script will continue as usual.
; #Warn , ,StdOut 				; Enable warnings to assist with detecting common errors.
; #Warn , ,OutputDebug          ; Send a description of the warning to the debugger for display. If a debugger is not active, this will have no effect.
#WinActivateForce


; Shutdown, 0 ; LOGOFF
; Shutdown, 1 ; SHUTDOWN
; Shutdown, 3 ; REBOOT
; Shutdown, 4 ; FORCE
; Shutdown, 8 ; POWERDOWN
Sleep, 1000
ExitApp

