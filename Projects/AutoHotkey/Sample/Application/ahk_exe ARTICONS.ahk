; =========================================================================================== [HOTKEY] [AUTO CREATE SIZE]
 XButton2::
	function_articons(6)	;256x256
	function_articons(4)	;48x48
	function_articons(3)	;32x32
	function_articons(2)	;24x24
	function_articons(1)	;16x16
	;SendInput, ^s
Return

; =========================================================================================== [HOTKEY] [CLOSE FILE]
XButton1::
	SendInput, ^{F4}
Return

; =========================================================================================== [FUNCITONS]
function_articons(size){
	SendInput, ^i
	SendInput, !%size%
	SendInput, {ENTER}
	SendInput, {ENTER}
	Sleep, 300
}
