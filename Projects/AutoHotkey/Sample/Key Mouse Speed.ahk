; =========================================================================================== [OPTIONS]
#Include %A_ScriptDir%\\Script\Options.ahk
; =========================================================================================== [FUNCTION] [TOOLTIP]
#Include %A_ScriptDir%\\Script\ToolTip.ahk
; @ToolTipTimeOut_Specify_Global = -5000  ; Re-Assign value for Specified TimeOut
; @ToolTipTimeOut_Default_Global = -2000  ; Re-Assign value for Default TimeOut
; =========================================================================================== [FUNCTIONS]
#Include %A_ScriptDir%\\Script\Functions.ahk
; =========================================================================================== [VARIABLES]
; M_SPEED (Range 1-20, 10 is default)
MOUSE_SPEED_CURRENT = null
MOUSE_SPEED_SPECIFIED = 1
; SPI_GETMOUSESPEED := 0x70		; GET PRESENT MOUSE SPEED
; SPI_SETMOUSESPEED := 0x71		; SET SPECIFIED MOUSE SPEED
; =========================================================================================== [FILES]
; =========================================================================================== [HOTKEY] [LABEL]
Hotkey, ~LShift,  Off
Return
; =========================================================================================== [OPTIONS] [RETURN]

; =========================================================================================== [FUNCTION]
set_mouse_speed_value_primary(speed_value_primary){
Sleep, 100
DllCall("SystemParametersInfo", "UInt", 0x71, "UInt", 0, "Ptr", speed_value_primary, "UInt", 0)
}
; =========================================================================================== [FUNCTION]
set_mouse_speed_value_secondary(speed_value_secondary){
Sleep, 100
GLOBAL MOUSE_SPEED_SPECIFIED = speed_value_secondary
}
; =========================================================================================== [LABEL]
get_mouse_speed_current:
; Get the present mouse speed and store it to MOUSE_SPEED_CURRENT variable.
DllCall("SystemParametersInfo", "UInt", 0x70, "UInt", 0, "UIntP", MOUSE_SPEED_CURRENT, "UInt", 0)
Return
; =========================================================================================== [LABEL]
set_mouse_speed_specified:
; Set the mouse speed to MOUSE_SPEED_SPECIFIED value.
DllCall("SystemParametersInfo", "UInt", 0x71, "UInt", 0, "Ptr", MOUSE_SPEED_SPECIFIED, "UInt", 0)
Return
; =========================================================================================== [LABEL]
set_mouse_speed_current:
; Set the mouse back to the Current Speed State
DllCall("SystemParametersInfo", "UInt", 0x71, "UInt", 0, "Ptr", MOUSE_SPEED_CURRENT, "UInt", 0)
Return
; =========================================================================================== [HOTKEY] [SET PRIMARY MOUSE POINTER SPEED]
~LButton & Numpad1::
set_mouse_speed_value_primary(1)
Return
~LButton & Numpad2::
set_mouse_speed_value_primary(2)
Return
~LButton & Numpad3::
set_mouse_speed_value_primary(3)
Return
~LButton & Numpad4::
set_mouse_speed_value_primary(4)
Return
~LButton & Numpad5::
set_mouse_speed_value_primary(5)
Return
~LButton & Numpad6::
set_mouse_speed_value_primary(6)
Return
~LButton & Numpad7::
set_mouse_speed_value_primary(7)
Return
~LButton & Numpad8::
set_mouse_speed_value_primary(8)
Return
~LButton & Numpad9::
set_mouse_speed_value_primary(9)
Return
~LButton & Numpad0::
set_mouse_speed_value_primary(10)
Return
~LButton & NumpadDot::
~LButton & NumpadDel::
set_mouse_speed_value_primary(11)
Return
; =========================================================================================== [HOTKEY] [SET SECONDARY MOUSE POINTER SPEED]
~RButton & Numpad1::
set_mouse_speed_value_secondary(1)
Return
~RButton & Numpad2::
set_mouse_speed_value_secondary(2)
Return
~RButton & Numpad3::
set_mouse_speed_value_secondary(3)
Return
~RButton & Numpad4::
set_mouse_speed_value_secondary(4)
Return
~RButton & Numpad5::
set_mouse_speed_value_secondary(5)
Return
~RButton & Numpad6::
set_mouse_speed_value_secondary(6)
Return
~RButton & Numpad7::
set_mouse_speed_value_secondary(7)
Return
~RButton & Numpad8::
set_mouse_speed_value_secondary(8)
Return
~RButton & Numpad9::
set_mouse_speed_value_secondary(9)
Return
~RButton & Numpad0::
set_mouse_speed_value_secondary(10)
Return
~RButton & NumpadDot::
~RButton & NumpadDel::
set_mouse_speed_value_secondary(11)
Return
; =========================================================================================== [HOTKEY] [TOGGLE SECONDARY MOUSE POINTER SPEED]
~RButton & MButton::
Hotkey, ~LShift,  Toggle
Return
~LShift::
Gosub, get_mouse_speed_current
Gosub, set_mouse_speed_specified
if GetKeyState("LShift")
	KeyWait, LShift
Gosub, set_mouse_speed_current
Return
~LShift Up::
Gosub, set_mouse_speed_current
Return
; =========================================================================================== [HOTKEY] [EXIT APP]
#Include %A_ScriptDir%\\Script\ExitApp.ahk
