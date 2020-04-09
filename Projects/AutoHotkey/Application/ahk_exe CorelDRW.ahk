; =========================================================================================== [HOTKEY]
XButton2::
	SendInput, ^{Space}
	KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY]
XButton1::
	SendInput, {F10}
	KeyWait, XButton1
Return
; =========================================================================================== [HOTKEY]
~LButton & RButton::
	SendInput, p
	KeyWait, RButton
Return
