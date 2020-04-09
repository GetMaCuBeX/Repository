#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
SetWorkingDir %A_ScriptDir% 	; Ensures a consistent starting directory.
#Warn  ; Enable warnings to assist with detecting common errors.
CoordMode, Mouse, Window
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
#SingleInstance force 	;Skips the dialog box and replaces the old instance automatically, which is similar in effect to the Reload command.
;#SingleInstance ignore 	;Skips the dialog box and leaves the old instance running. In other words, attempts to launch an already-running script are ignored.
;#SingleInstance off 	;Allows multiple instances of the script to run concurrently.
SetTitleMatchMode 2
DetectHiddenWindows On
#WinActivateForce
; #NoTrayIcon
; D:\MaCuBeX\Pictures\Icons\Applications\CSGO.ico
Menu, Tray, Icon, main.cpl, 1
SetControlDelay 1
SetWinDelay 0
SetKeyDelay -1
SetMouseDelay -1
SetBatchLines -1
#UseHook
#Persistent 	; Prevent the script from exiting automatically.


sens:=2.51
zoomsens:=1

;Key binds
key_AK:="F4"
key_M4A1:="F6"
key_M4A4:="F7"
key_Famas:="F8"
key_Galil:="F9"
key_UMP:="F12"
key_AUG:="Home"
key_SG:="End"
key_RCoff:="F11"
key_Terminate:="F10"
key_shoot:="LButton"
key_zoom:="LAlt"

; Return

;do not touch this if you don't know what are you doing
; modifier:=2.52/sens
modifier:=2.5/sens

loop
{ ; [FIRST LOOP]

/*
Hotkey, *~$Space, Off
Hotkey, *~$MButton, Off
Hotkey, *~$t, Off
*/
	ak:=true ; SET AK

	sleep 1
	;Menu handling
	if GetKeyState(key_AK)
	{
		SoundPlay, %A_ScriptDir%\BELL1.mp3
		; SoundPlay, %A_ScriptDir%\1.mp3
		ak:=true
		m4a1:=false
		m4a4:=false
		famas:=false
		galil:=false
		ump:=false
		aug:=false
		sg:=false
	}

	if GetKeyState(key_M4A1)
	{
		; SoundPlay, %A_ScriptDir%\2.mp3
		m4a1:=true
		ak:=false
		m4a4:=false
		famas:=false
		galil:=false
		ump:=false
		aug:=false
		sg:=false
	}


	if GetKeyState(key_shoot)
	{
		if ak ; ak = TRUE
		{
			loop
			{ ; [SECOND LOOP]
				DllCall("mouse_event", uint, 2, int, 0, int, 0, uint, 0, int, 0)
				sleep 50
				if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 7*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 7*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 4*modifier, "UInt", 19*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 1*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -3*modifier, "UInt", 29*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 15*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -1*modifier, "UInt", 31*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 15*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 13*modifier, "UInt", 31*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 15*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 8*modifier, "UInt", 28*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 19*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 13*modifier, "UInt", 21*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 11*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -17*modifier, "UInt", 12*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 2*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -42*modifier, "UInt", -3*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", -3*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -21*modifier, "UInt", 2*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 2*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 12*modifier, "UInt", 11*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 11*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -15*modifier, "UInt", 7*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 7*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -26*modifier, "UInt", -8*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", -8*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -3*modifier, "UInt", 4*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 4*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 40*modifier, "UInt", 1*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 1*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 19*modifier, "UInt", 7*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 7*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 14*modifier, "UInt", 10*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 10*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 27*modifier, "UInt", 0*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 0*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 33*modifier, "UInt", -10*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", -10*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -21*modifier, "UInt", -2*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", -2*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 7*modifier, "UInt", 3*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 3*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -7*modifier, "UInt", 9*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 9*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -8*modifier, "UInt", 4*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 4*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 19*modifier, "UInt", -3*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", -3*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", 5*modifier, "UInt", 6*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 6*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -20*modifier, "UInt", -1*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", -1*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
				; DllCall("mouse_event", "UInt", 0x01, "UInt", -33*modifier, "UInt", -4*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", -4*modifier)
				sleep 99
				if !GetKeyState(key_shoot)
					{
					DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
					break
					}
					; DllCall("mouse_event", "UInt", 0x01, "UInt", -45*modifier, "UInt", -21*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", -21*modifier)
				sleep 99
					if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
					; DllCall("mouse_event", "UInt", 0x01, "UInt", -14*modifier, "UInt", 1*modifier)
				DllCall("mouse_event", "UInt", 0x01, "UInt", modifier, "UInt", 1*modifier)
					if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
					sleep 80
				DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				sleep 1000
					if !GetKeyState(key_shoot)
				    {
				    DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
				    break
				    }
			} ; END [SECOND LOOP]
		} ; END [ak]
	} ; END [key_shoot]

} ; END [FIRST LOOP]
; -------------------------------------------------------------------------------------------
;
;
;
;
;
;
;
; -------------------------------------------------------------------------------------------

/*
*~$Space::
sleep 1
loop
{
GetKeyState, SpaceState, Space, P
if Spacestate = U
break
sleep 1
Send, {Blind}{Space}
}
return

*~$MButton::
sleep 10
loop
{
GetKeyState, state, MButton
if state = U
break
Sleep 1
Send, {Blind}{LButton}
}
return

*~$t::
DllCall("mouse_event", "UInt", 0x01, "UInt", 223*modifier, "UInt", 0)
sleep 1
DllCall("mouse_event", "UInt", 0x01, "UInt", 432*modifier, "UInt", 0)
sleep 1
DllCall("mouse_event", "UInt", 0x01, "UInt", 432*modifier, "UInt", 0)
sleep 1
DllCall("mouse_event", "UInt", 0x01, "UInt", 432*modifier, "UInt", 0)
sleep 1
DllCall("mouse_event", "UInt", 0x01, "UInt", 432*modifier, "UInt", 0)
sleep 1
DllCall("mouse_event", "UInt", 0x01, "UInt", 432*modifier, "UInt", 0)
sleep 1
DllCall("mouse_event", "UInt", 0x01, "UInt", 432*modifier, "UInt", 0)
sleep 1
DllCall("mouse_event", "UInt", 0x01, "UInt", 432*modifier, "UInt", 0)
sleep 200
return
*/
