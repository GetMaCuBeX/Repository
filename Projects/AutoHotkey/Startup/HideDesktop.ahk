; [#] Directives
#KeyHistory, 0					; Disable key history.
#MaxThreadsPerHotkey, 1 		; No re-entrant hotkey handling.
#NoTrayIcon
; Menu, Tray, Icon, main.cpl, 3
#NoEnv                          ; Recommended for performance and compatibility with future AutoHotkey releases.
#Persistent                     ; Prevent the script from exiting automatically.
#SingleInstance force           ; Skips the dialog box and replaces the old instance automatically, which is similar in effect to the Reload command.
; #SingleInstance ignore 		; Skips the dialog box and leaves the old instance running. In other words, attempts to launch an already-running script are ignored.
; #SingleInstance off 			; Allows multiple instances of the script to run concurrently.
#UseHook
#Warn 			     			; Enable warnings to assist with detecting common errors.




Gosub, toggle_view_desktop_icons
Gosub, ExitThisHotkey


toggle_view_desktop_icons:
	ControlGet, HWND_VAR, Hwnd, , SysListView321, ahk_class Progman
	IsDesktopIconVisible := DllCall("IsWindowVisible", UInt, HWND_VAR)
		If (IsDesktopIconVisible) 	;CHECK IF DESKTOP ICON IS VISIBLE
		WinHide, ahk_id %HWND_VAR% 	;HIDE DESKTOP ICON
	Else
	; WinShow, ahk_id %HWND_VAR% 	;SHOW DESKTOP ICON
Return


ExitThisHotkey:
	ExitApp
Return
