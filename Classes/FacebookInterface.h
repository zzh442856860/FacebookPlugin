﻿//
//  FacebookInterface.h
//
//  Created by Ruoqian, Chen on 2014/10/17
//
//  forked from https://github.com/Ryeeeeee/FacebookTutorial

#ifndef  __INTERFACE_FACEBOOK_H__
#define  __INTERFACE_FACEBOOK_H__

#include "BaseDef.h"

class FacebookInterface
{
public:
	static void callback(int cbIndex, const char *pszParams);

	static void request(int nIndex, const char*pszRequest, const char *pszPermission);
	static void login(int cbIndex, const char* scope = NULL);
	static void logout(void);
	static bool isLogin(void);
    static const char* getStatus(void);
    static void pickFriend(void);
    static void postStatus(const char* name, const char* caption, const char* description, const char* link, const char* picture);
    static void sendRequests(void);
};
#endif  //__INTERFACE_FACEBOOK_H__
