package org.xdi.oxauth.ws.rs;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xdi.oxauth.BaseTest;
import org.xdi.oxauth.client.*;
import org.xdi.oxauth.model.common.ResponseMode;
import org.xdi.oxauth.model.common.ResponseType;
import org.xdi.oxauth.model.register.ApplicationType;
import org.xdi.oxauth.model.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * @author Javier Rojas Blum
 * @version October 1, 2015
 */
public class AuthorizationResponseModeHttpTest extends BaseTest {

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void defaultResponseModeBasicCode(final String userId, final String userSecret,
                                             final String redirectUris, final String redirectUri) throws Exception {
        showTitle("defaultResponseModeBasicCode");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, null);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.QUERY);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void fragmentResponseModeBasicCode(final String userId, final String userSecret,
                                              final String redirectUris, final String redirectUri) throws Exception {
        showTitle("fragmentResponseModeBasicCode");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, null);
        authorizationRequest.setResponseMode(ResponseMode.FRAGMENT);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FRAGMENT);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void queryResponseModeBasicCode(final String userId, final String userSecret,
                                           final String redirectUris, final String redirectUri) throws Exception {
        showTitle("queryResponseModeBasicCode");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, null);
        authorizationRequest.setResponseMode(ResponseMode.QUERY);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.QUERY);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void formPostResponseModeBasicCode(final String userId, final String userSecret,
                                              final String redirectUris, final String redirectUri) throws Exception {
        showTitle("formPostResponseModeBasicCode");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, null);
        authorizationRequest.setResponseMode(ResponseMode.FORM_POST);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FORM_POST);
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void defaultResponseModeImplicitIdToken(final String userId, final String userSecret,
                                                   final String redirectUris, final String redirectUri) throws Exception {
        showTitle("defaultResponseModeImplicitIdToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.ID_TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FRAGMENT);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void fragmentResponseModeImplicitIdToken(final String userId, final String userSecret,
                                                    final String redirectUris, final String redirectUri) throws Exception {
        showTitle("fragmentResponseModeImplicitIdToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.ID_TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.FRAGMENT);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FRAGMENT);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void queryResponseModeImplicitIdToken(final String userId, final String userSecret,
                                                 final String redirectUris, final String redirectUri) throws Exception {
        showTitle("queryResponseModeImplicitIdToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.ID_TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.QUERY);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.QUERY);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void formPostResponseModeImplicitIdToken(final String userId, final String userSecret,
                                                    final String redirectUris, final String redirectUri) throws Exception {
        showTitle("formPostResponseModeImplicitIdToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.ID_TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.FORM_POST);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FORM_POST);
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void defaultResponseModeImplicitIdTokenToken(final String userId, final String userSecret,
                                                        final String redirectUris, final String redirectUri) throws Exception {
        showTitle("defaultResponseModeImplicitIdTokenToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.ID_TOKEN, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FRAGMENT);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getAccessToken());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void fragmentResponseModeImplicitIdTokenToken(final String userId, final String userSecret,
                                                         final String redirectUris, final String redirectUri) throws Exception {
        showTitle("fragmentResponseModeImplicitIdTokenToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.ID_TOKEN, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.FRAGMENT);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FRAGMENT);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getAccessToken());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void queryResponseModeImplicitIdTokenToken(final String userId, final String userSecret,
                                                      final String redirectUris, final String redirectUri) throws Exception {
        showTitle("queryResponseModeImplicitIdTokenToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.ID_TOKEN, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.QUERY);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.QUERY);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getAccessToken());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void formPostResponseModeImplicitIdTokenToken(final String userId, final String userSecret,
                                                         final String redirectUris, final String redirectUri) throws Exception {
        showTitle("formPostResponseModeImplicitIdTokenToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.ID_TOKEN, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.FORM_POST);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FORM_POST);
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void defaultResponseModeHybridCodeIdToken(final String userId, final String userSecret,
                                                     final String redirectUris, final String redirectUri) throws Exception {
        showTitle("defaultResponseModeHybridCodeIdToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.ID_TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FRAGMENT);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void fragmentResponseModeHybridCodeIdToken(final String userId, final String userSecret,
                                                      final String redirectUris, final String redirectUri) throws Exception {
        showTitle("fragmentResponseModeHybridCodeIdToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.ID_TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.FRAGMENT);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FRAGMENT);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void queryResponseModeHybridCodeIdToken(final String userId, final String userSecret,
                                                   final String redirectUris, final String redirectUri) throws Exception {
        showTitle("queryResponseModeHybridCodeIdToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.ID_TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.QUERY);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.QUERY);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void formPostResponseModeHybridCodeIdToken(final String userId, final String userSecret,
                                                      final String redirectUris, final String redirectUri) throws Exception {
        showTitle("formPostResponseModeHybridCodeIdToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.ID_TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.FORM_POST);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FORM_POST);
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void defaultResponseModeHybridCodeIdTokenToken(final String userId, final String userSecret,
                                                          final String redirectUris, final String redirectUri) throws Exception {
        showTitle("defaultResponseModeHybridCodeIdTokenToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.ID_TOKEN, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FRAGMENT);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getAccessToken());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void fragmentResponseModeHybridCodeIdTokenToken(final String userId, final String userSecret,
                                                           final String redirectUris, final String redirectUri) throws Exception {
        showTitle("fragmentResponseModeHybridCodeIdTokenToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.ID_TOKEN, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.FRAGMENT);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FRAGMENT);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getAccessToken());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void queryResponseModeHybridCodeIdTokenToken(final String userId, final String userSecret,
                                                        final String redirectUris, final String redirectUri) throws Exception {
        showTitle("queryResponseModeHybridCodeIdTokenToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.ID_TOKEN, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.QUERY);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.QUERY);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getAccessToken());
        assertNotNull(authorizationResponse.getIdToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void formPostResponseModeHybridCodeIdTokenToken(final String userId, final String userSecret,
                                                           final String redirectUris, final String redirectUri) throws Exception {
        showTitle("formPostResponseModeHybridCodeIdTokenToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.ID_TOKEN, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.FORM_POST);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FORM_POST);
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void defaultResponseModeHybridCodeToken(final String userId, final String userSecret,
                                                   final String redirectUris, final String redirectUri) throws Exception {
        showTitle("defaultResponseModeHybridCodeToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FRAGMENT);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getAccessToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void fragmentResponseModeHybridCodeToken(final String userId, final String userSecret,
                                                    final String redirectUris, final String redirectUri) throws Exception {
        showTitle("fragmentResponseModeHybridCodeToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.FRAGMENT);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FRAGMENT);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getAccessToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void queryResponseModeHybridCodeToken(final String userId, final String userSecret,
                                                 final String redirectUris, final String redirectUri) throws Exception {
        showTitle("queryResponseModeHybridCodeToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.QUERY);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.QUERY);
        assertNotNull(authorizationResponse.getLocation());
        assertNotNull(authorizationResponse.getCode());
        assertNotNull(authorizationResponse.getAccessToken());
        assertNotNull(authorizationResponse.getState());
    }

    @Parameters({"userId", "userSecret", "redirectUris", "redirectUri"})
    @Test
    public void formPostResponseModeHybridCodeToken(final String userId, final String userSecret,
                                                    final String redirectUris, final String redirectUri) throws Exception {
        showTitle("formPostResponseModeHybridCodeToken");

        List<ResponseType> responseTypes = Arrays.asList(ResponseType.CODE, ResponseType.TOKEN);

        // 1. Register client
        RegisterRequest registerRequest = new RegisterRequest(ApplicationType.WEB, "oxAuth test app",
                StringUtils.spaceSeparatedToList(redirectUris));
        registerRequest.setResponseTypes(responseTypes);

        RegisterClient registerClient = new RegisterClient(registrationEndpoint);
        registerClient.setRequest(registerRequest);
        RegisterResponse registerResponse = registerClient.exec();

        showClient(registerClient);
        assertEquals(registerResponse.getStatus(), 200, "Unexpected response code: " + registerResponse.getEntity());
        assertNotNull(registerResponse.getClientId());
        assertNotNull(registerResponse.getClientSecret());
        assertNotNull(registerResponse.getRegistrationAccessToken());
        assertNotNull(registerResponse.getClientIdIssuedAt());
        assertNotNull(registerResponse.getClientSecretExpiresAt());

        String clientId = registerResponse.getClientId();

        // 2. Request authorization
        List<String> scopes = Arrays.asList("openid", "profile", "address", "email");
        String nonce = UUID.randomUUID().toString();
        String state = UUID.randomUUID().toString();

        AuthorizationRequest authorizationRequest = new AuthorizationRequest(responseTypes, clientId, scopes, redirectUri, nonce);
        authorizationRequest.setResponseMode(ResponseMode.FORM_POST);
        authorizationRequest.setState(state);

        AuthorizationResponse authorizationResponse = authenticateResourceOwnerAndGrantAccess(
                authorizationEndpoint, authorizationRequest, userId, userSecret);

        assertEquals(authorizationResponse.getResponseMode(), ResponseMode.FORM_POST);
    }
}
