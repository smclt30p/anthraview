![alt tag](http://i.imgur.com/zVhstfP.png)

# Anthraview 1.0 build 221
### Anthrazit Logger Viewer

---

This is a log viewer with timestamp formatting and
coloring support. It can be used with any language, 
given that the language follows the Anthrazit Logging 
Stadard.

---

### Anthrazit Logging Standard
---
If you want to write a logger compatible with 
Anhtraview, please follow these standards:

Write to a file lines of text, UTF-8 encoded, 
in this format:

```
[EPOCH] {SEVERITY} LOGTAG% MESSAGE$
```

Elements:
 * EPOCH - Unix epoch
 * SEVERITY - Logging severity, Anthraview supports
DEBUG, INFO, ERROR, FATAL and EXCEPTION in the 
SEVERITY field.
 * LOGTAG - the log tag, should be all lowercase if
possible for style reasons.
 * MESSAGE - The log message itself. Supports also 
formatting line \n, \t etc.

The "$" symbol indicates end of line, while the 
"%" symbol indicates end of log tag. Anthraview
is also space-sensitive up to the "%" tag, so please
pay attention to that. You can refer to the examples
directory for a log example.
