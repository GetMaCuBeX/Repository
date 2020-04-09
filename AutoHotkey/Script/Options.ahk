; =========================================================================================== [OPTIONS]
								; [#] Directives
#KeyHistory, 0              	; Disable key history.
#MaxThreadsPerHotkey, 1     	; No re-entrant hotkey handling.
;  #NoTrayIcon
Menu, Tray, Icon, main.cpl, 4
#NoEnv                       	; Recommended for performance and compatibility with future AutoHotkey releases.
#Persistent                  	; Prevent the script from exiting automatically.
#SingleInstance force        	; Skips the dialog box and replaces the old instance automatically, which is similar in effect to the Reload command.
; #SingleInstance ignore       	; Skips the dialog box and leaves the old instance running. In other words, attempts to launch an already-running script are ignored.
; #SingleInstance off          	; Allows multiple instances of the script to run concurrently.
#UseHook
; #Warn                        	; Enable warnings to assist with detecting common errors.
; #Warn , ,MsgBox              	; Show a message box describing the warning. Note that once the message box is dismissed, the script will continue as usual.
#Warn , ,StdOut              	; Enable warnings to assist with detecting common errors.
; #Warn , ,OutputDebug         	; Send a description of the warning to the debugger for display. If a debugger is not active, this will have no effect.
#WinActivateForce
; CoordMode, Mouse, Client     	; Coordinates are relative to the active window's client area, which excludes the window's title bar, menu (if it has a standard one) and borders. Client coordinates are less dependent on OS version and theme
; CoordMode, Mouse, Relative   	; Send a description of the warning to stdout (the program's standard output stream), along with the filename and line number.
CoordMode, Mouse, Screen     	; Coordinates are relative to the desktop (entire screen).
; CoordMode, Mouse, Window     	; Synonymous with Relative and recommended for clarity
CoordMode, ToolTip, Screen
DetectHiddenWindows On
ListLines, Off               	; Displays the script lines most recently executed.
SendMode Input               	; Forces Send and SendRaw to use SendInput buffering for speed. Recommended for new scripts due to its superior speed and reliability.
SetBatchLines -1
SetControlDelay 1
SetKeyDelay -1
SetTitleMatchMode, 2
; SetTitleMatchMode, 3         	; A window's title must exactly match WinTitle to be a match.
SetMouseDelay -1
; SetWinDelay 0
SetWinDelay, -1              	; Remove short delay done automatically after every windowing command except IfWinActive and IfWinExist.
SetWorkingDir %A_ScriptDir%  	; Ensures a consistent starting directory.
