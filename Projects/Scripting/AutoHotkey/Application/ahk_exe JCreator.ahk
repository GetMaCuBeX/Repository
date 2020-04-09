; =========================================================================================== [HOTKEY]
XButton2::
	SendInput, ^s
	KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY] [RUN FILE]
XButton1::
	SendInput, {F5}
	KeyWait, XButton1
Return
; =========================================================================================== [HOTKEY]
~LAlt & s::
	SendInput, System.out.println(); {LEFT 3}
Return
