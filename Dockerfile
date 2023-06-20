FROM docker.io/library/java-springboot-custom
LABEL "io.openshift.s2i.build.commit.id"="a7179aa2eeece5e68d0decdcac30d334b74b4cb3" \
      "io.openshift.s2i.build.commit.ref"="main" \
      "io.openshift.s2i.build.commit.message"="Inclusión de gitignore" \
      "io.openshift.s2i.build.source-location"="/home/dzapata/Proyectos/Altice/wsresttestgit/." \
      "io.k8s.display-name"="wsresttestgit" \
      "io.openshift.s2i.build.image"="docker.io/library/java-springboot-custom" \
      "io.openshift.s2i.build.commit.author"="Daniel Zapata <dzapata@colsof.com.co>" \
      "io.openshift.s2i.build.commit.date"="Thu Jun 15 12:57:39 2023 -0500"

USER root
# Copying in source code
COPY upload/src /tmp/src
# Change file ownership to the assemble user. Builder image must support chown command.
RUN chown -R 1001:0 /tmp/src
USER 1001
# Assemble script sourced from builder image based on user input or image metadata.
# If this file does not exist in the image, the build will fail.
RUN /usr/libexec/s2i/assemble
# Run script sourced from builder image based on user input or image metadata.
# If this file does not exist in the image, the build will fail.
CMD /usr/libexec/s2i/run
