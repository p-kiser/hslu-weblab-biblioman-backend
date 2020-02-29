package com.pkiser.weblab.biblioman.security;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * This implementation provides the username for the auditing annotations.
 *
 * @author pkiser
 */
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.of("system");
    }
}
