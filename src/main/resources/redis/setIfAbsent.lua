local key1 = KEYS[1]
local value = ARGV[1]
local time = tonumber(ARGV[2])
if(redis.call('setnx',key1,value) == 1) then
    redis.call('expire',key1,time)
    return 1
else
    return 0
end