 ; =========================================================================================== [HOTKEY] [AUTO CREATE SIZE]
 XButton2::
	function_icolover(5)	;256x256
	function_icolover(8)	;128x128
							;96x96
	function_icolover(6)	;64x64
	function_icolover(4)	;48x48
	function_icolover(3)	;32x32
	function_icolover(2)	;24x24
	function_icolover(0)	;20x20
	function_icolover(1)	;16x16
	;SendInput, ^s
Return

; =========================================================================================== [HOTKEY] [CLOSE FILE]
XButton1::
	SendInput, ^{F4}
Return

; =========================================================================================== [FUNCITONS]
function_icolover(size){
	SendInput, ^i
	SendInput, !%size%
	SendInput, {ENTER}
	SendInput, {ENTER}
	Sleep, 300
}
