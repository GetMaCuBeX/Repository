;Subscribe to Gaming With Zahin on YouTube!!!
;https://www.youtube.com/c/gamingwithzahin
;Settings
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

;do not touch this if you don't know what are you doing
modifier:=2.52/sens
Hotkey, *~$Space, Off
Hotkey, *~$MButton, Off
Hotkey, *~$t, Off

;Main program loop, don't break out of it
loop {
sleep 1
;Menu handling
if GetKeyState(key_AK)
{
SoundPlay, %A_ScriptDir%\1.mp3
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
SoundPlay, %A_ScriptDir%\2.mp3
m4a1:=true
ak:=false
m4a4:=false
famas:=false
galil:=false
ump:=false
aug:=false
sg:=false
}

if GetKeyState(key_M4A4)
{
SoundPlay, %A_ScriptDir%\3.mp3
m4a4:=true
ak:=false
m4a1:=false
famas:=false
galil:=false
ump:=false
aug:=false
sg:=false
}

if GetKeyState(key_Famas)
{
SoundPlay, %A_ScriptDir%\4.mp3
famas:=true
ak:=false
m4a1:=false
m4a4:=false
galil:=false
ump:=false
aug:=false
sg:=false
}

if GetKeyState(key_Galil)
{
SoundPlay, %A_ScriptDir%\5.mp3
galil:=true
ak:=false
m4a1:=false
m4a4:=false
famas:=false
ump:=false
aug:=false
sg:=false
}

if GetKeyState(key_Terminate)
{
SoundPlay, %A_ScriptDir%\8.mp3
sleep 2000
ExitApp
}

if GetKeyState(key_RCoff)
{
SoundPlay, %A_ScriptDir%\7.mp3
ak:=false
m4a1:=false
m4a4:=false
famas:=false
galil:=false
ump:=false
aug:=false
sg:=false
}

if GetKeyState(key_UMP)
{
SoundPlay, %A_ScriptDir%\6.mp3
ump:=true
ak:=false
m4a1:=false
m4a4:=false
famas:=false
galil:=false
aug:=false
sg:=false
}

if GetKeyState(key_SG)
{
SoundPlay, %A_ScriptDir%\9.mp3
sg:=true
ump:=false
ak:=false
m4a1:=false
m4a4:=false
famas:=false
galil:=false
aug:=false
}

if GetKeyState(key_AUG)
{
SoundPlay, %A_ScriptDir%\10.mp3
aug:=true
ump:=false
ak:=false
m4a1:=false
m4a4:=false
famas:=false
galil:=false
sg:=false
}

;NoRecoil
if GetKeyState(key_shoot)
{
;AK-47
if ak
{
loop
{
DllCall("mouse_event", uint, 2, int, 0, int, 0, uint, 0, int, 0)
sleep 50
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 7*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 4*modifier, "UInt", 19*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -3*modifier, "UInt", 29*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -1*modifier, "UInt", 31*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 13*modifier, "UInt", 31*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 8*modifier, "UInt", 28*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 13*modifier, "UInt", 21*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -17*modifier, "UInt", 12*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -42*modifier, "UInt", -3*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -21*modifier, "UInt", 2*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 12*modifier, "UInt", 11*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -15*modifier, "UInt", 7*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -26*modifier, "UInt", -8*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -3*modifier, "UInt", 4*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 40*modifier, "UInt", 1*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 19*modifier, "UInt", 7*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 14*modifier, "UInt", 10*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 27*modifier, "UInt", 0*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 33*modifier, "UInt", -10*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -21*modifier, "UInt", -2*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 7*modifier, "UInt", 3*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -7*modifier, "UInt", 9*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -8*modifier, "UInt", 4*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 19*modifier, "UInt", -3*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 5*modifier, "UInt", 6*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -20*modifier, "UInt", -1*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -33*modifier, "UInt", -4*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -45*modifier, "UInt", -21*modifier)
sleep 99
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -14*modifier, "UInt", 1*modifier)
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
}
}
;M4A1-S
else if m4a1
{
loop
{
DllCall("mouse_event", uint, 2, int, 0, int, 0, uint, 0, int, 0)
sleep 15
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 1*modifier, "UInt", 6*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 0*modifier, "UInt", 4*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 14*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 4*modifier, "UInt", 18*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -6*modifier, "UInt", 21*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 24*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 14*modifier, "UInt", 14*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 8*modifier, "UInt", 12*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 18*modifier, "UInt", 5*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 10*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -14*modifier, "UInt", 5*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -25*modifier, "UInt", -3*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -19*modifier, "UInt", 0*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -22*modifier, "UInt", -3*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 1*modifier, "UInt", 3*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 8*modifier, "UInt", 3*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -9*modifier, "UInt", 1*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -13*modifier, "UInt", -2*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 3*modifier, "UInt", 2*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 1*modifier, "UInt", 1*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
sleep 1000
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
}
}
;M4A4
else if m4a4
{
loop
{
DllCall("mouse_event", uint, 2, int, 0, int, 0, uint, 0, int, 0)
sleep 15
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 2*modifier, "UInt", 7*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 0*modifier, "UInt", 9*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -6*modifier, "UInt", 16*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 7*modifier, "UInt", 21*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -9*modifier, "UInt", 23*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -5*modifier, "UInt", 27*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 16*modifier, "UInt", 15*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 11*modifier, "UInt", 13*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 22*modifier, "UInt", 5*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 11*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -18*modifier, "UInt", 6*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -30*modifier, "UInt", -4*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -24*modifier, "UInt", 0*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -25*modifier, "UInt", -6*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 0*modifier, "UInt", 4*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 8*modifier, "UInt", 4*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -11*modifier, "UInt", 1*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -13*modifier, "UInt", -2*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 2*modifier, "UInt", 2*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 33*modifier, "UInt", -1*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 10*modifier, "UInt", 6*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 27*modifier, "UInt", 3*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 10*modifier, "UInt", 2*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 11*modifier, "UInt", 0*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -12*modifier, "UInt", 0*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 6*modifier, "UInt", 5*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 4*modifier, "UInt", 5*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 3*modifier, "UInt", 1*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 4*modifier, "UInt", -1*modifier)
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
sleep 1000
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
}
}
;Famas
else if famas
{
loop
{
DllCall("mouse_event", uint, 2, int, 0, int, 0, uint, 0, int, 0)
sleep 30
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 5*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 1*modifier, "UInt", 4*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -6*modifier, "UInt", 10*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -1*modifier, "UInt", 17*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 0*modifier, "UInt", 20*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 14*modifier, "UInt", 18*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 16*modifier, "UInt", 12*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -6*modifier, "UInt", 12*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -20*modifier, "UInt", 8*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -16*modifier, "UInt", 5*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -13*modifier, "UInt", 2*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 4*modifier, "UInt", 5*modifier)
sleep 87
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 23*modifier, "UInt", 4*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 12*modifier, "UInt", 6*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 20*modifier, "UInt", -3*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 5*modifier, "UInt", 0*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 15*modifier, "UInt", 0*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 3*modifier, "UInt", 5*modifier)
sleep 80
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 3*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -25*modifier, "UInt", -1*modifier)
sleep 80
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -3*modifier, "UInt", 2*modifier)
sleep 84
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 11*modifier, "UInt", 0*modifier)
sleep 80
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 15*modifier, "UInt", -7*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 15*modifier, "UInt", -10*modifier)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
sleep 1000
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
}
}
;Galil
else if galil
{
loop
{
DllCall("mouse_event", uint, 2, int, 0, int, 0, uint, 0, int, 0)
sleep 10
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 4*modifier, "UInt", 4*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -2*modifier, "UInt", 5*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 6*modifier, "UInt", 10*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 12*modifier, "UInt", 15*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -1*modifier, "UInt", 21*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 2*modifier, "UInt", 24*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 6*modifier, "UInt", 16*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 11*modifier, "UInt", 10*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 14*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -22*modifier, "UInt", 8*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -30*modifier, "UInt", -3*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -29*modifier, "UInt", -13*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -9*modifier, "UInt", 8*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -12*modifier, "UInt", 2*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -7*modifier, "UInt", 1*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 0*modifier, "UInt", 1*modifier)
sleep 50
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 4*modifier, "UInt", 7*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 25*modifier, "UInt", 7*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 14*modifier, "UInt", 4*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 25*modifier, "UInt", -3*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 31*modifier, "UInt", -9*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 6*modifier, "UInt", 3*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -12*modifier, "UInt", 3*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 13*modifier, "UInt", -1*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 10*modifier, "UInt", -1*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 16*modifier, "UInt", -4*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -9*modifier, "UInt", 5*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -32*modifier, "UInt", -5*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -24*modifier, "UInt", -3*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -15*modifier, "UInt", 5*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 6*modifier, "UInt", 8*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -14*modifier, "UInt", -3*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -24*modifier, "UInt", -14*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -13*modifier, "UInt", -1*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
sleep 1000
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
}
}
;UMP-45
else if ump
{
loop
{
DllCall("mouse_event", uint, 2, int, 0, int, 0, uint, 0, int, 0)
sleep 15
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -1*modifier, "UInt", 6*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 8*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -2*modifier, "UInt", 18*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 23*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -9*modifier, "UInt", 23*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -3*modifier, "UInt", 26*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 11*modifier, "UInt", 17*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier, "UInt", 12*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 9*modifier, "UInt", 13*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 18*modifier, "UInt", 8*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 15*modifier, "UInt", 5*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -1*modifier, "UInt", 3*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 5*modifier, "UInt", 6*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 0*modifier, "UInt", 6*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 9*modifier, "UInt", -3*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 5*modifier, "UInt", -1*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -12*modifier, "UInt", 4*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -19*modifier, "UInt", 1*modifier)
sleep 85
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -1*modifier, "UInt", -2*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 15*modifier, "UInt", -5*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 17*modifier, "UInt", -2*modifier)
sleep 85
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -6*modifier, "UInt", 3*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -20*modifier, "UInt", -2*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -3*modifier, "UInt", -1*modifier)
sleep 90
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
sleep 1000
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
}
}
;AUG
else if aug
{
if GetKeyState(key_zoom)
{
;this is the best scale I could figure out for zoomed in norecoil
obs:=1.2/zoomsens
}
else
{
obs:=1
}
loop
{
DllCall("mouse_event", uint, 2, int, 0, int, 0, uint, 0, int, 0)
sleep 30
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 5*modifier*obs, "UInt", 6*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 0*modifier*obs, "UInt", 13*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -5*modifier*obs, "UInt", 22*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -7*modifier*obs, "UInt", 26*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 5*modifier*obs, "UInt", 29*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 9*modifier*obs, "UInt", 30*modifier*obs)
sleep 80
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 14*modifier*obs, "UInt", 21*modifier*obs)
sleep 80
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 6*modifier*obs, "UInt", 15*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 14*modifier*obs, "UInt", 13*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -16*modifier*obs, "UInt", 11*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -5*modifier*obs, "UInt", 6*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 13*modifier*obs, "UInt", 0*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 1*modifier*obs, "UInt", 6*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -22*modifier*obs, "UInt", 5*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -38*modifier*obs, "UInt", -11*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -31*modifier*obs, "UInt", -13*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -3*modifier*obs, "UInt", 6*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -5*modifier*obs, "UInt", 5*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -9*modifier*obs, "UInt", 0*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 24*modifier*obs, "UInt", 1*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 32*modifier*obs, "UInt", 3*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 15*modifier*obs, "UInt", 6*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -5*modifier*obs, "UInt", 1*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 17*modifier*obs, "UInt", -3*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 29*modifier*obs, "UInt", -11*modifier*obs)
sleep 95
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 19*modifier*obs, "UInt", 0*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -16*modifier*obs, "UInt", 6*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -16*modifier*obs, "UInt", 3*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier*obs, "UInt", 1*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
sleep 1000
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
}
}
;SG 553
else if sg
{
if GetKeyState(key_zoom)
{
;this is the best scale I could figure out for zoomed in norecoil
obs:=1.2/zoomsens
}
else
{
obs:=1
}
loop
{
DllCall("mouse_event", uint, 2, int, 0, int, 0, uint, 0, int, 0)
sleep 30
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -4*modifier*obs, "UInt", 9*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -13*modifier*obs, "UInt", 15*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -9*modifier*obs, "UInt", 25*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -6*modifier*obs, "UInt", 29*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -8*modifier*obs, "UInt", 31*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -7*modifier*obs, "UInt", 36*modifier*obs)
sleep 80
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -20*modifier*obs, "UInt", 14*modifier*obs)
sleep 80
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 14*modifier*obs, "UInt", 17*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -8*modifier*obs, "UInt", 12*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -15*modifier*obs, "UInt", 8*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -5*modifier*obs, "UInt", 5*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 6*modifier*obs, "UInt", 5*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -8*modifier*obs, "UInt", 6*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 2*modifier*obs, "UInt", 11*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -14*modifier*obs, "UInt", -6*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -20*modifier*obs, "UInt", -17*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -18*modifier*obs, "UInt", -9*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -8*modifier*obs, "UInt", -2*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 41*modifier*obs, "UInt", 3*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 56*modifier*obs, "UInt", -5*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 43*modifier*obs, "UInt", -1*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 18*modifier*obs, "UInt", 9*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 14*modifier*obs, "UInt", 9*modifier*obs)
sleep 88
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 6*modifier*obs, "UInt", 7*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 21*modifier*obs, "UInt", -3*modifier*obs)
sleep 95
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", 29*modifier*obs, "UInt", -4*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -6*modifier*obs, "UInt", 8*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -15*modifier*obs, "UInt", 5*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", "UInt", 0x01, "UInt", -38*modifier*obs, "UInt", -5*modifier*obs)
sleep 89
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
sleep 1000
if !GetKeyState(key_shoot)
{
DllCall("mouse_event", uint, 4, int, 0, int, 0, uint, 0, int, 0)
break
}
}
}
}
}

;Bhop
~F1::
Hotkey, *~$Space, Toggle
SoundPlay, %A_ScriptDir%\12.mp3
return
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

;Rapid fire
~F2::
Hotkey, *~$MButton, Toggle
SoundPlay, %A_ScriptDir%\13.mp3
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

;180 Turnaround
F3::
Hotkey, *~$t, Toggle
SoundPlay, %A_ScriptDir%\11.mp3
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