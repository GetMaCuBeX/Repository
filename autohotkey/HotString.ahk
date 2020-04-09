

; =========================================================================================== [HOTKEY] [NETBEANS IDE]
#IfWinActive ahk_exe netbeans64.exe
; =========================================================================================== [HOTSTRING] [SOP]
:C:FXML:: 	; Typed in all-caps.
	SendInput, FXMLLoader.load(getClass().getResource(""));
	Sleep, 50
	SendInput, !+{f}
	Sleep, 50
	SendInput, {LEFT 4}
	Sleep, 50
Return

; =========================================================================================== [HOTSTRING] [SOP]
; :~*:.:: 	; Typed in all-caps.
; 	Sleep, 100
; 	SendInput, ^{space}
; 	Sleep, 50
; Return


