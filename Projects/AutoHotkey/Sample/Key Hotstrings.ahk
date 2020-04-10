; =========================================================================================== [OPTIONS]
#Include %A_ScriptDir%\\Script\Options.ahk
; =========================================================================================== [FUNCTION] [TOOLTIP]
#Include %A_ScriptDir%\\Script\ToolTip.ahk
; @ToolTipTimeOut_Specify_Global = -5000  ; Re-Assign value for Specified TimeOut
; @ToolTipTimeOut_Default_Global = -2000  ; Re-Assign value for Default TimeOut
; =========================================================================================== [VARIABLES]
; =========================================================================================== [FILES]
file_ccleaner64 = C:\Program Files\CCleaner\CCleaner64.exe
Return
; =========================================================================================== [OPTIONS] [RETURN]

; =========================================================================================== [HOTSTRINGS] [OPTIONS]
; #Hotstring NoMouse                   	; Prevents mouse clicks from resetting the hotstring recognizer.
#Hotstring EndChars - ( )[]{}':         ; Use this [Char] to activate the [Hotstring] add [Space] to make {Spacebar} as part of [EndingChar].
#Hotstring EndChars - "/\,.?!`n `t      ; Note that [`n] is {Enter}, [`t] is {Tab}, and there is a plain {space} between [`n] and [`t].

; #Hotstring ?                          ; [?]   The hotstring will be triggered even when it is inside another word; that is, when the character typed immediately before it is alphanumeric.
; #Hotstring b                          ; [b]   Will automatically remove the [Hotstring] "Abbreviation".
; #Hotstring b0                         ; [b0]  This won't removed the [Hotstring] "Abbreviation".
; #Hotstring c                          ; [c]   All the below hotstrings will be case sensitive by default.
; #Hotstring c0                         ; [c0]  Make all hotstrings below this point case insensitive.
; #Hotstring k                          ; [k]   Sets the delay between keystrokes produced by auto-backspacing[b] or auto-replacement[b].
; #Hotstring kn                         ; [kn]  Specify the new delay for n; for example, specify k10 to have a 10ms delay and k-1 to have no delay.
; #Hotstring O                          ; [O]   Omit[Delete/Ignore] the ending character of auto-replace hotstrings when the replacement is produced.
; #Hotstring O                          ; [O]   If you use [EndChars] to activate the [Hotstring]. The [EndChars] you used will be remove without have to press {Backspace}.
; #Hotstring r                          ; [r]   Send the replacement text "raw"; that is, without translating {Enter} to Enter, ^c to Control+C, etc.
; #Hotstring X                          ; [X]   Instead of replacement text, the hotstring accepts a command or expression to execute.
; #Hotstring Z                          ; [Z]   resets the hotstring recognizer after each triggering of the hotstring. In other words, the script will begin waiting for an entirely new hotstring, eliminating from consideration anything you previously typed. This can prevent unwanted triggerings of hotstrings.

:?:ol::online                           ; [?]   Typing "paracitamol " would produce "paracitamonline ". The [Hotstring] "Abbreviation" is removed. Use [?0] to turn this option back off.
:?0:al::airline                         ; [?0]  Typing "practical " would produce "practical "

                                        ; [*]   An ending character (e.g. {Space}, ., or {Enter} is NOT required to TRIGGER the [Hotstring].
:*b0:<em>::</em>{left 5}                ; [*b0] Typing "<em>" would produce "<em>|</ex>". The [Caret] is move 5 times to the Left.
:*b:<ex>::</ex>{left 5}                 ; [*b]  Typing "<ex>" would produce "|</ex>". The [Caret] is move 5 times to the Left.

                                        ; [C]   When you type an "abbreviation", it must exactly match the case defined in the script. Use [C0] to turn case sensitivity back off.
:C:BTW::                                ; [C]	Typed in all-caps.
:C:Btw::                                ; [C]	Typed with only the first letter upper-case.
: :btw::                                ; 		Typed in any other combination.
case_conform_btw() {
    hs := A_ThisHotkey                  ; For convenience and in case we're interrupted.
    if (hs == ":C:BTW")
        Send BY THE WAY
    else if (hs == ":C:Btw")
        Send By the way
    else
        Send by the way
RunTollTipDisplay(hs, @ToolTipTimeOut_Specify_Global)
}
return

:o:ar::aristocrat                       ; [o]   Typing "ar" + "[EndChars]" would produce "aristocrat". The [EndChars] is removed.

:r:raw1::{Alt}                          ; [r]   Typing "raw2" would produce "{Alt} " text.
:r:raw2::{Enter}                        ; [r]   Typing "raw2" would produce "{Enter} " text.

:X:~mb::MsgBox                          ; [X]   Typing "~mb" would SHOW MESSAGE DIALOG BOX.

                                        ; [Z]   Since the above lacks the [Z] option.
:b0*?:11::                              ; [Z]   Typing 111 (three consecutive 1's) would trigger the hotstring twice because the middle 1 is the last character of the first triggering but also the first character of the second triggering.
SendInput Aa                            ; [Z]   Typing "11" would produce "11Aa" text. If you type again with "1" this will execute the [Hotstring] and produce "11Aa1Aa".
return
:b0Z*?:22::                             ; [Z]   By adding the letter [Z} in front of b0, you would have to type four 1's instead of three to trigger the hotstring twice. Use Z0 to turn this option back off.
SendInput Aa                            ; [Z]   Typing "22" would produce "22Aa" text. If you type again with "22" this will execute the [Hotstring] and produce "22Aa22Aa".
return
; =========================================================================================== [HOTSTRING] [OPTIONS] [RETURN]
;
;
;
;
;
;
;
;
;
;
;
;
; =========================================================================================== [HOTSTRING]
:*:time::
FormatTime, OutputVar, , h:mm:ss tt
MsgBox, %OutputVar%
Return


:X*:+s::
RunTollTipDisplay("Sad", @ToolTipTimeOut_Specify_Global)
Return



:*:et::  ; This hotstring replaces "dt" with the current date and time via the commands below.
FormatTime, CurrentDateTimex,, M/d/yyyy h:mm tt  ; It will look like 9/1/2005 3:53 PM
FormatTime, CurrentDateTimex,, yyyy-MM-dd hh-mm-ss tt ; It will look like 2020-03-14 08-40-00 AM
MsgBox, %CurrentDateTimex%
Return


:r:text1::
(
Any text between the top and bottom parentheses is treated literally, including commas and percent signs.
By default, the hard carriage return {Enter} between the previous line and this one is also preserved.
    By default, the indentation {tab{ to the left of this line is preserved.
)
Return

; =========================================================================================== [HOTSTRING]
:*:cc::
If (FileExist(file_ccleaner64))
	Run, %file_ccleaner64% /AUTO
Return

; =========================================================================================== [HOTKEY]
~RControl::
SendInput, ^s
KeyWait, RControl
Run, %A_ScriptFullPath%
Return


; =========================================================================================== [HOTKEY] [EXIT APP]
#Include %A_ScriptDir%\\Script\ExitApp.ahk
